package Review;

public class Review1222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b,c,d;
		a=5;
		b=4;
		c=7;
		d=9;
		
		System.out.println(a*=b+c+d);
		System.out.println(a++);
		System.out.println(a+b);
		System.out.println(++a);
		//@++ -> @값에 +1을 하게 된 값
		//System.out.println(a++) -> 후처리++이기에 결과값은 a값만 나옴
		//하지만 이후 a값은 a+1값으로 처리됨
	}

}
