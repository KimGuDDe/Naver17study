package Day1218;

class Car
{
	static String carCompany="Hyundai";
			
	private String carName;
	private int carPrice;
	
	
	public static void setCarCompany(String carCompany)
	{
		Car.carCompany=carCompany;
	}
	
	//setter method
	public void setCarName(String carName)
	{
		this.carName=carName;
		
	}
	public void setCarprice(int carPrice)
	{
		this.carPrice=carPrice;
		
	}
	
	//getter method
	public String getCarName()
	{
		return carName;//this 는 생략 가능
	}
	
	public int getCarPrice()
	{
		return carPrice;//this 는 생략 가능
	}
	//두가지 한꺼번에 변경할 경우 호출
	public void setData(String carName,int carPrice)
	{
		this.setCarName(carName);
		this.setCarprice(carPrice);
	}
}

public class Ex9Object {

	public static void writeCarInfo(Car mycar)
	{
		System.out.println("=".repeat(30));
		System.out.println("자동차명 : "+mycar.getCarName());
		System.out.println("가 격 : "+ mycar.getCarPrice());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 자동차 회사명 : "+Car.carCompany);
		Car.setCarCompany("삼성");
		System.out.println("변경된 자동차 회사명 : "+Car.carCompany);
		
		Car car1=new Car();
		car1.setCarName("Grandeur");
		car1.setCarprice(4500);
		
		Car car2=new Car();
		car2.setData("Sonata", 3200);
		
		Car car3=new Car();
		car3.setData("Ferari", 20000);
		
//		System.out.println("car1 자동차명 : "+ car1.getCarName());
//		System.out.println("car1 가격 : "+ car1.getCarPrice());
//		System.out.println("=".repeat(30));
//		System.out.println("car2 자동차명 : "+ car2.getCarName());
//		System.out.println("car2 가격 : "+ car2.getCarPrice());
		
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	}

}
