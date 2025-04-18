package Day1227;

@FunctionalInterface
interface Workable
{
	void work(String name,String job);
}
@FunctionalInterface
interface Speakable
{
	void speak(String content);
}

class Person {
	public void action1(Workable workable)
	{
		workable.work("홍길동", "프로그래밍");
	}



	public void action2(Speakable speakable)
	{ 
		speakable.speak("안녕하세요");
	}


	public class review1227 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Person person = new Person();

			person.action1((name,job) ->
			{
				System.out.println(name + "이");
				System.out.println(job + "을(를) 합니다");
			});

			person.action1((name,job) -> System.out.println(name +"이"+job+"을 하지 않습니다"));
		}

	}
}


