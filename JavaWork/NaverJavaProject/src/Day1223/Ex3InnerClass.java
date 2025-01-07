package Day1223;

abstract class AbstEx
{
	abstract public void show();
}

interface MyDB
{
	public void list();
	public void insert();
}

class SubMyDB implements MyDB
{

	@Override
	public void list() {
		System.out.println("list");
		// TODO Auto-generated method stub

	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("insert");

	}

}

public class Ex3InnerClass {

	AbstEx abst1 = new AbstEx() {

		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("show 호출");
		}
	};

	MyDB myDb = new MyDB() {

		@Override
		public void list() {
			// TODO Auto-generated method stub
			System.out.println("list");
		}

		@Override
		public void insert() {
			// TODO Auto-generated method stub

		}
	};

	MyDB myDB2 = new SubMyDB();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.abst1.show();
		System.out.println();
		ex3.myDb.insert();
		ex3.myDb.list();
		System.out.println();
		ex3.myDB2.insert();
		ex3.myDB2.list();


	}
}







