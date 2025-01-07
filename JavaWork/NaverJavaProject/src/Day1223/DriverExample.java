package Day1223;

//public class Vehicle {
//		// TODO Auto-generated method stub
//		public void run()
//		{
//		System.out.println("차량이 달립니다.");
//		
//		}
//}
///////////////////////////////////////
//class Bus extends Vehicle
//{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//		System.out.println("버스가 달립니다");
//	}
//}
///////////////////////////////////////////////
interface Vehicle
{
	public void run();
}

class Taxi implements Vehicle
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다");
	}
}
class Bus implements Vehicle
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("택시가 달립니다");
	}
}
//class Taxi extends Vehicle
//{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//		System.out.println("택시가 달립니다");
//	}
//}
///////////////////////////////////////////
class Driver
{
	public void drive(Vehicle vehicle)
	{
		vehicle.run();
	}
}
////////////////////////////////////
class DriverExample
{
	public static void main(String[] args)
	{
		Driver driver = new Driver();

		Bus bus = new Bus();
		driver.drive(bus);

		Taxi taxi = new Taxi();
		driver.drive(taxi);
	}
}
