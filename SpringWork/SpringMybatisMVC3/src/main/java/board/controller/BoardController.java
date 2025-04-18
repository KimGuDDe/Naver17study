package board.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.dto.BoardRepleDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardRepleService;
import data.service.BoardService;
import data.service.MemberService;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final BoardRepleService repleService;
	final NcpObjectStorageService storageService;
	
	
	//버켓 이름	
	private String bucketName="bitcamp-bucket-103";//각자 자기꺼 써야함
	
	@GetMapping("/writeform")
	public String writeForm(
			//아래 4개의 값은 답글일 때만 넘어온다. 새글일 때는 null 갑이 넘어오므로
			//required 를 false 로 주거나 defaultValue를 지정해야 한다
			@RequestParam(value = "idx",defaultValue = "0") int idx,
			@RequestParam(value = "regroup",defaultValue = "0") int regroup,
			@RequestParam(value = "restep",defaultValue = "0") int restep,
			@RequestParam(value = "relevel",defaultValue = "0") int relevel,
			@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			Model model)
	{
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpSession session)
	{	
		//세션으로부터 아이디 얻기
		String userId = (String) session.getAttribute("loginid");
		//아이디를 이용해서 멤버 테이블에서 작성자를 얻는다
		String writer = memberService.getSelectByMyid(userId).getMname();
		dto.setMyid(userId);
		dto.setWriter(writer);
		//게시판 내용을 일단 db 에 저장(그래야 idx 값을 얻어올 수 있다)		
		boardService.insertBoard(dto);
	    int idx = dto.getIdx();	   
		//파일이 있는 경우에만 해당, 네이버 스토리지에 저장 후(이 때 필요한 게 idx,filename)
	    if (upload != null && !upload.isEmpty()) {
	        for (MultipartFile file : upload) {
	            if (!file.isEmpty()) {
	                // 파일을 네이버 스토리지에 업로드
	                String fileName = storageService.uploadFile(bucketName, "board", file);
	                
	                // 파일 정보를 DB에 저장
	                BoardFileDto dto1 = new BoardFileDto();
	                dto1.setIdx(idx);
	                dto1.setFilename(fileName);
	                fileService.insertBoardFile(dto1);
	            }
	        }
	    }

	    
		return "redirect:./list?pageNum="+pageNum;
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int idx,
			@RequestParam(defaultValue = "1") int pageNum,Model model)
	{	
		
		// 조회수 증가 (필요 시)
	    boardService.updateReadcount(idx); // BoardService에 해당 메서드가 필요
		
		// 게시글 정보 가져오기
	    BoardDto dto = boardService.getSelectByIdx(idx);
	    
	    // 첨부파일 목록 가져오기
	    List<String> fileList = new Vector<>();
	    List<BoardFileDto> files = fileService.getFiles(idx);
	    for(BoardFileDto fdto:files)
	    {
	    	fileList.add(fdto.getFilename());
	    }
	    
	    dto.setPhotos(fileList);
	    
	    // 작성자 정보 가져오기	    
	    String memberPhoto = memberService.getSelectByMyid(dto.getMyid()).getMphoto();
	    
	    //댓글 정보 가져오기	
	    List<BoardRepleDto> repleList = repleService.getReples(idx);

	    // 모델에 데이터 추가
	    model.addAttribute("dto", dto);
	    model.addAttribute("memberPhoto", memberPhoto);
	    model.addAttribute("files", files);
	    model.addAttribute("pageNum", pageNum);
	    model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+bucketName);
	    model.addAttribute("repleList", repleList); // 댓글 목록 추가!!
    
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform")
    public String updateForm(
            @RequestParam int idx,
            @RequestParam(defaultValue = "1") int pageNum,
            Model model,
            HttpSession session) {
        String userId = (String) session.getAttribute("loginid");
        BoardDto dto = boardService.getSelectByIdx(idx);

        // 작성자 확인
        if (!dto.getMyid().equals(userId)) {
            return "redirect:/board/detail?idx=" + idx + "&pageNum=" + pageNum;
        }

        List<BoardFileDto> files = fileService.getFiles(idx);
        model.addAttribute("dto", dto);
        model.addAttribute("files", files);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/" + bucketName);
        return "board/updateform";
    }
	
	@PostMapping("/update")
    public String update(
            @ModelAttribute BoardDto dto,
            @RequestParam int pageNum,
            HttpSession session) {
        String userId = (String) session.getAttribute("loginid");
        BoardDto existingDto = boardService.getSelectByIdx(dto.getIdx());

        if (!existingDto.getMyid().equals(userId)) {
            return "redirect:/board/detail?idx=" + dto.getIdx() + "&pageNum=" + pageNum;
        }

        boardService.updateList(dto); // 제목, 내용만 업데이트
        return "redirect:/board/detail?idx=" + dto.getIdx() + "&pageNum=" + pageNum;
    }
	
	// Ajax 파일 추가
    @PostMapping("/addfile")
    @ResponseBody
    public BoardFileDto addFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam int idx,
            HttpSession session) {
        String userId = (String) session.getAttribute("loginid");
        BoardDto dto = boardService.getSelectByIdx(idx);       

        if (!file.isEmpty()) {
            String fileName = storageService.uploadFile(bucketName, "board", file);
            BoardFileDto fileDto = new BoardFileDto();
            fileDto.setIdx(idx);
            fileDto.setFilename(fileName);
            fileService.insertBoardFile(fileDto);
            return fileDto; // 추가된 파일 정보 반환
        }
        return null;
    }

    // Ajax 파일 삭제
    @PostMapping("/deletefile")
    @ResponseBody
    public String deleteFile(
            @RequestParam int num,
            @RequestParam int idx,
            HttpSession session) {
        String userId = (String) session.getAttribute("loginid");
        BoardDto dto = boardService.getSelectByIdx(idx);       
        BoardFileDto files = fileService.getFileByNum(num);
        
        if (files != null) {
            storageService.deleteFile(bucketName, "board", files.getFilename()); // NCP 스토리지에서 삭제
            fileService.deleteFile(num); // DB에서 삭제
            return "success";
        }
        return "fail";
    }
    
    @GetMapping("/delete")
    @ResponseBody
    public void deletList(
    		@RequestParam int idx,
    	    @RequestParam(defaultValue = "1") int pageNum,
    	    HttpSession session)
    {
    	
            List<BoardFileDto> files = fileService.getFiles(idx);
            for(BoardFileDto file : files) {
            	
            	String filename = file.getFilename();
                storageService.deleteFile(bucketName, "board", filename);
                fileService.deleteFile(file.getNum());
            
            // 게시글 삭제
            boardService.deleteList(idx);           
            }
    }
}
