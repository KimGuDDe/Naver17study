package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.ShopDto;
import data.service.ShopService;

@Controller
public class ShopListController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/list")
	public String shopList(Model model)
	{
		//총 상품 갯수
		int totalCount = shopService.getTotalCount();
		//전체 상품 갯수
		List<ShopDto> list = shopService.getAllSangpum();
		//메인사진 등록
//		for(ShopDto dto:list)
//		{
//			String mainPhoto = dto.getSphoto().split(",")[0]; //,로 연결된ㅅ ㅏ진 중 첫번쨰 사진
//			dto.setSphoto(mainPhoto);
//		}
		
		for(int i=0;i<list.size();i++)
		{
			String mainPhoto=list.get(i).getSphoto().split(",")[0];
			list.get(i).setMainPhoto(mainPhoto);
		}
		//모델에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("fronturl", "https://pmz6rdz88731.edge.naverncp.com/xfhLTFI0cg");
		model.addAttribute("backurl", "?type=f&w=120&h=120&ttype=jpg");
		//포워드
		return "shop/shoplist";
	}
}
