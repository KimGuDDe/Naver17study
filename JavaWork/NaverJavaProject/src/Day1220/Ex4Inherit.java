package Day1220;

import Day1220_2.Apple;

/////////////////////////////////////////////////
class Orange extends Apple
{
	public void play()
	{
		this.job();//public
		this.study();//protected
		//this.draw(); //오류발생 : 패키지가 달라서 상속관계더라도 접근불가
		this.process();
	}
	protected void process() {//더 넓은 범위로 허용
		//void process() {//오류
		//private void process {//오류
		//public void process() {오류 안남
		{
			super.process();
			System.out.println("Oracle,Mysql 공부를 더 깊게 합니다");
		}

	}
	public class Ex4Inherit {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	}
}
