package day1212;

public class Ex1Operater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//증감 연산자, ++변수(전치:1순위),변수++(후치:끝순위)
		int a,b,m,n;
		a=b=5;//대입연산자는 오른쪽부터 인식됨 b=5 -> b=5 = a
		m=++a;//먼저 a가 증가된 후 m으로 대입된다
		n=b++;//먼저 대입 후 b 증가된다
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=b=m=n=5;
		m=a++*++b;//5*6
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		n=a++ + ++b;//6+7
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		a=5;
		System.out.println(a++);//먼저 출력 후 증가 -> 뭐하러 이렇게 함?
		System.out.println(++a);//먼저 증가후 출력		
		
		a=b=m=n=5;
		a*=b-- - ++n*3;
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);
		
		
		
		
	}

}