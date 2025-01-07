package day1219;

public class Ex10MyCarArray {

	public static void showTitle()
	{
		System.out.println("자동차면\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	
	public static void writeMyCar(MyCar myCar)
	{
		System.out.println(myCar.getCarName()+"\t"+myCar.getCarPrice()+"\t"+
							myCar.getCarColor()+"\t"+myCar.getBuyDay());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar my1=new MyCar();
		System.out.println(my1); //toString 이 있을 경우 자동 호출된다.
		
		MyCar my2 = new MyCar("Sonata", 4000, "brown");
				System.out.println(my2);
				
		System.out.println("객체 배열 생성");
		
		//방법1
//		MyCar []carArray = {
//				new MyCar(),
//				new MyCar("Grandeur", 5600, "Black"),
//				new MyCar("BMW", 7000, "White")
//				
//		};
		
		//방법2
		
		MyCar [] carArray=new MyCar[3];//메모리 할당, 초기값 null
		carArray[0]= new MyCar();
		carArray[1]= new MyCar("Grandeur", 5600, "Black");
		carArray[2]= new MyCar("BMW", 7000, "White");
		//제목출력
		showTitle();
		
		//for 문으로 데이터 출력
//		for(MyCar my:carArray)
//			writeMyCar(my);
		
		for(int i=0;i<carArray.length;i++)
			writeMyCar(carArray[i]);
	}

}
