package Day1223;

class UserException extends Exception
{
	public UserException(String message) {
		
		super(message);
	}
}
///////////////////////////////////////////////////
public class Ex12UserException {
	
	public static void inputName(String name) throws UserException
	{
		if(name.equals("장원영") || name.equals("안유진"))
			throw new UserException("거짓이름을 말하고 있습니다"); //exception 강제 발생
		else
			System.out.println("내 이름은 " + name + "입니다");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inputName("성시경");
		} catch (UserException e) {
			System.out.println("오류메세지 :"+ e.getMessage());
		}
		
		try {
			inputName("장원영");
		} catch (UserException e) {
			System.out.println("오류메세지 :"+ e.getMessage());
		}
		
		System.out.println("정상종료");
	}

}
