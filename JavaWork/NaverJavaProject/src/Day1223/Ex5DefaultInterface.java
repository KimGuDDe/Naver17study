package Day1223;
/*
 * jdk8 에서 추가된 기능
 * 디폴트 인스턴스 메소드를 통해서 기능 구현 가능
 */
interface RemoteControl
{
	//상수 선언
	int Max_VOLUMN = 10;
	int MIN_VOLUMN = 0;
	
	//추상 메소드들
	public void turnon();
	public void turnoff();
	public void setVolumn(int volumn);
	
	default void setMute(boolean mute)
	{
		if(mute)
		{
			System.out.println("무음 처리합니다");
			setVolumn(MIN_VOLUMN);
		}
		else
		{
			System.out.println("무음 해제합니다");
		}
	}
}

class Television implements RemoteControl
{

	int volumn;
	
	@Override
	public void turnon() {
		// TODO Auto-generated method stub
		System.out.println("티비 온");
	}

	@Override
	public void turnoff() {
		// TODO Auto-generated method stub
		System.out.println("티비 오프");
	}

	@Override
	public void setVolumn(int volumn) {
		// TODO Auto-generated method stub
		System.out.println(" 현재 볼륨은 " + this.volumn +"입니다");
	}
	
}
public class Ex5DefaultInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc1 = null; //new 로 생성 안됨
		//rc1.setMute(false); //null 포인트 이셉션이라는 오류 발생
		rc1 = new Television();
		rc1.turnon();
		rc1.turnoff();
		rc1.setMute(false);
		rc1.setMute(true);
	}

}
