package Day1223;

abstract class AbstSawon
{
	abstract public void addSawon();
	abstract public void removerSawon();
}
/////////////////////////////////////////////
interface InterSales
{
	public void insertSangPum();
	public void selectSangPum();
}
/////////////////////////////////////////////
//위 클래스와 인터페이스를 익명 내부 클래스 형태로 구현 후
//메인으로 호출하시오
public class Ex4InnerClass {
	AbstSawon Sawon = new AbstSawon() {
		
		@Override
		public void removerSawon() {
			// TODO Auto-generated method stub
			System.out.println("사원을 목록에서 제거합니다");
		}
		
		@Override
		public void addSawon() {
			// TODO Auto-generated method stub
			System.out.println("사원을 목록에서 추가합니다");
		}
	};
	
	InterSales sales = new InterSales() {
		
		@Override
		public void selectSangPum() {
			// TODO Auto-generated method stub
			System.out.println("상품을 선택합니다");
		}
		
		@Override
		public void insertSangPum() {
			// TODO Auto-generated method stub
			System.out.println("상품을 추가합니다");
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4InnerClass ex4 = new Ex4InnerClass();
		ex4.Sawon.addSawon();
		ex4.Sawon.removerSawon();
		System.out.println();
		ex4.sales.insertSangPum();
		ex4.sales.selectSangPum();
	}

}
