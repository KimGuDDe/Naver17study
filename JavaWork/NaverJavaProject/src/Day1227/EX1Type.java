package Day1227;

class GenericType<T>
{
	
	T []v;
	
	public void set(T[] n)
	{
		v=n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			System.out.print(s+" ");
		}
		System.out.println();
	}
}	

public class EX1Type {
	//<T>는 T가 type 파라미터임을 뜻함
	//타입이 필요한 자리에 T를 쓴다(클래스 타입만 가능)	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []s = {"장미꽃","안개꽃","국화꽃","벚꽃"};
		Integer []n= {90,80,100,78,98};
		Double []d= {3.2,4.6,33.2,3.5,56.8};
		
		GenericType<String> gt1 = new GenericType<>();
		gt1.set(s);
		gt1.print();
		System.out.println();
		GenericType<Integer> gt2 = new GenericType<>();
		gt2.set(n);
		gt2.print();
		System.out.println();
		GenericType<Double> gt3 = new GenericType<>();
		gt3.set(d);
		gt3.print();
		System.out.println();
	}

}
