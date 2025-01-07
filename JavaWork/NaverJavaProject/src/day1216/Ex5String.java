package day1216;

public class Ex5String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String 클래스의 멤버 메소드에 대한 공부");
		String str1="Apple";
		String str2="Have a nice day!!";
		String str3="Orange";
		String str4=new String("Apple");
		
		System.out.println("str1"+str1);
		System.out.println("str2"+str2);
		System.out.println("str3"+str3);
		
		System.out.println("str2의 길이"+str2.length());
		System.out.println("str1의 0번째 글자"+str1.charAt(0));
		System.out.println("str2의 3번째 글자"+str1.charAt(3));
		System.out.println("str3의 2번째 글자"+str1.charAt(2));
		
		System.out.println();
		System.out.println("str1에서 l의 위치는 : "+str1.indexOf('l'));//3
		System.out.println("str1에서 a의 위치는 : "+str2.indexOf('a'));//1 : 첫번째 a의 위치
		System.out.println("str2에서 마지막 a의 위치는 : "+str2.lastIndexOf('a'));
		System.out.println("str1에서 x의 위치는 : "+str3.indexOf('x'));//해당 문자 없을 시 -1이 출력
		System.out.println();
		
		
		//객체 타입에서 == 동등연산자가 주소를 비교하는 연산자
		System.out.println(str1==str4); //false
		System.out.println(str3=="Orange");
		System.out.println(str1=="apple");
		
		//equals 사용 - 문자열을 정확하게 비교하려면
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals("apple"));//대소문자까지 모두 맞아야 true
		System.out.println(str1.equalsIgnoreCase("apple"));//대소문자 상관없이 철자만 맞으면 ok
		
		System.out.println("문자열 비교-compareTo");
		int n=str1.compareTo("Apple");
		System.out.println(n);//0 : 대소문자까지 같을 경우
		
		n=str1.compareTo("Canada");
		System.out.println(n);//문자열1이 문자열2보다 작을경우 -값이 나옴
		
		n=str3.compareTo(str1); // Orange와 Apple을 비교
		System.out.println(n);
		
		System.out.println();
		System.out.println("str2를 모두 대문자로 변환 :"+str2.toUpperCase());
		System.out.println("str2를 모두 소문자로 변환 :"+str2.toLowerCase());
		
		System.out.println();
		System.out.println("str2가 Have로 시작하면 true :"+str2.startsWith("Have"));
		System.out.println("str2가 Happy로 시작하면 true :"+str2.startsWith("Happy"));
		
		System.out.println("str2가 Day!!로 끝나면 true"+str2.endsWith("Day!!"));
		System.out.println("str2가 Day!로 끝나면 true"+str2.endsWith("Day!"));
		System.out.println();
		
		System.out.println("=".repeat(50));
		System.out.println(str1.repeat(3));
		
		System.out.println();
		System.out.println(str2.replace("a","*"));
		System.out.println(str2.replace("nice","Happy"));
		
		System.out.println(str2.substring(7));//7번 index부터 끝까지 추출
		System.out.println(str2.substring(7,10));//7~9까지 추출
		
		System.out.println("split으로 문자열 분리(배열)");
		String str5 = "red, green, blue, yellow, gray, black";
		System.out.println("str5 :"+str5);
		String []array=str5.split(",");
		//배열 출력
		for(String a:array)
			System.out.println(a);
		
		String str6= "   Hello   ";
		System.out.println("*"+str6+"*");
		System.out.println("*"+str6.trim()+"*");//앞뒤 공백 제거 후 변환

		System.out.println();
		System.out.println("String.valueOf : 다양한 타입의 데이터를 String 타입으로 변환");
		
		//String s1=String.valueOf(100);
		String s1=100+""; //int+String=String : 간단한 방법
		String s2=String.valueOf(true);
		String s3=String.valueOf(34.6);
		String s4=String.valueOf('A');
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		
		
		
		
		
	}

}
