package day1219;

public class Sawon
{
		/*
		 * 멤버 변수 사원명 sawonName, 직급 positon, 가족 수 famsu 
		 */
	private String sawonName;
	private String position;
	private int famsu;
		
	/*
	 * 디폴트 생성자
	 * 사원명, 직급, 기본급 를 인자로 받는 생성자
	 */
	public Sawon()
	{
		super();
	}
	
	public Sawon(String sawonName, String position, int famsu)
	{
		this.sawonName=sawonName;
		this.position=position;
		this.famsu=famsu;
	}

	/*
	 * setter & getter method
	 */
	
	public String getSawonName() {
		return sawonName;
	}

	public void setSawonName(String sawonName) {
		this.sawonName = sawonName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamsu() {
		return famsu;
	}

	public void setFamsu(int famsu) {
		this.famsu = famsu;
	}
	
	/*
	 *  직급에 따라 기본급을 구하는데
	 *  부장-> 450, 과장->300, 대리->250, 사원->150
	 *  getBasicPay()
	 *  
	 */
	public int getBasicPay()
	{
		int basic=switch(position)
				{
				case "부장"->450;
				case "과장"->300;
				case "대리"->250;
				case "사원"->150;
				default -> 0;
				};
		return basic;
	}
	 
	 /*  
	 *  직급에 따라 수당을 구하는데 
	 *  부장,과장 -> 70/ 대리,사원 -> 50
	 *  getSuDang
	 */
	
	public int getSudang()
	{
		int sudang = switch(position)
				{
				case "부장","과장"-> 70;
				case "대리","사원"-> 50;
				default -> 0;
				};
		return sudang;
	}
	
	
	   
	 /*  getBasicPay() 값을 반환받아서 세금 5프로 구해서 반환하는
	 *  getTax()
	 */
	public int getTax()
	{
		int tax=getBasicPay()*5/100;
		return tax;
	}
	
	 /*  
	 *  가족 수가 5인 이상이면 30 반환, 5인 미만 2인 이상은 10반환, 나머지 0
	 *  getFamSudang()
	 */
	public int getFamsudang()
	{
		int famSudang=0;
		if(famsu>=5) famSudang=30;
		else if(famsu>=2) famSudang=10;
		else famSudang=0;
		
		return famSudang;
	}
	
	 /*  실수령액을 구해서 반환하는 메서드 기본급 + 수당 - 세금 + 가족수당을 구해서 반환
	 *  getNetPay()
	 */
	public int getNetPay()
	{
		return getBasicPay()+getSudang()-getTax()+getFamsudang();
	}
		
}
