package board.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardFileDto;
import data.dto.BoardRepleDto;
import data.service.BoardFileService;
import data.service.BoardRepleService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardRepleController {

	@Autowired
	final BoardRepleService repleService;
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;

	//버켓 이름	
	private String bucketName="bitcamp-bucket-103";//각자 자기꺼 써야함

	// 댓글 추가 (AJAX, 사진 포함)
	@PostMapping("/reple/insert")
	@ResponseBody
	public String insertReple(
			@RequestParam("idx") int idx, // idx 수신
			@RequestParam("message") String message, // 메시지 수신
			@RequestParam(value = "photoFile", required = false) MultipartFile photoFile, // 파일 수신
			HttpSession session) {
		try {

			String userId = (String) session.getAttribute("loginid");
			String myId = userId != null ? userId : "guest";

			BoardRepleDto dto = new BoardRepleDto();
			dto.setIdx(idx);
			dto.setMessage(message);
			dto.setMyid(myId);

			if (photoFile != null && !photoFile.isEmpty()) {	            
				String fileName = storageService.uploadFile(bucketName, "board", photoFile);
				dto.setPhoto(fileName);
			} else {	            
			}

			repleService.insertReple(dto);
			return "success";
		} catch (Exception e) {	        
			return "fail: " + e.getMessage();
		}
	}

	// 댓글 삭제 (AJAX)
	@GetMapping("/reple/delete")
	@ResponseBody
	public String deletList(
			@RequestParam int num)
	{

		BoardRepleDto rdto = new BoardRepleDto();
		// 2. 댓글이 있다면, 댓글들을 삭제한다.
		rdto = repleService.getRepleByNum(num);
		// 댓글에 첨부된 파일이 있다면, 스토리지에서 삭제
		if (rdto.getPhoto() != null) {
			storageService.deleteFile(bucketName, "board", rdto.getPhoto());
		}
		// 댓글 DB에서 삭제
		repleService.deleteReple(rdto.getNum()); // BoardRepleService에 해당 메서드가 필요

		return "success";
	}
	
	@PostMapping("/reple/update")
	@ResponseBody
	public String updateReple(
	        @RequestParam("num") int num,
	        @RequestParam("message") String message,
	        @RequestParam(value = "photoFile", required = false) MultipartFile photoFile) {
	    try {
	        BoardRepleDto dto = repleService.getRepleByNum(num);
	        if (dto == null) {
	            return "fail: 댓글이 존재하지 않습니다.";
	        }

	        // 기존 사진 삭제 (새로운 사진이 업로드된 경우)
	        if (photoFile != null && !photoFile.isEmpty()) {
	            if (dto.getPhoto() != null) {
	                storageService.deleteFile(bucketName, "board", dto.getPhoto());
	            }
	            String fileName = storageService.uploadFile(bucketName, "board", photoFile);
	            dto.setPhoto(fileName);
	        }

	        dto.setMessage(message);
	        repleService.updateReple(dto);
	        return "success";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "fail: " + e.getMessage();
	    }
	}
	
}