package bitcamp.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component	//mycar 이라는 이름으로 bean 이 등록된다
@Data
public class Mycar {
	@Value("아이디 A6")
	private String mycarName;
	@Value("진주색")
	private String mycarColor;
}
