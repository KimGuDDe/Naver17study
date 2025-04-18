package bitcamp.study;

import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class BitController {
	
	//@RestController 는 json 출력 시 @ResponseBody 안 붙인다
	@GetMapping("/hello")
	public List<TestDto> list()
	{
		List<TestDto> list = new Vector<>();
		list.add(new TestDto("강호동","서울","010-2223-4443"));
		list.add(new TestDto("장원영","경기","010-2233-4553"));
		list.add(new TestDto("원하늘","일산","010-2323-4543"));
		list.add(new TestDto("안유진","용인","010-2222-4643"));
		
		return list;
	}
	
}
