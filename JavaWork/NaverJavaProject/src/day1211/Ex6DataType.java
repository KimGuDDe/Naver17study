package day1211;

public class Ex6DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String 은 기본형이 아니고 객체 타입이다.
        String str1="Hello";
        String str2=new String("Happy");
        
        System.out.println(str1);
        System.out.println(str2);
        
        System.out.println("\t"+str1);
        System.out.println("\t\t"+str2);
        
        //printf 에서 문자열의 변환기호는 %s
        System.out.printf("%s\n",str1);
        System.out.printf("%50s\n",str1);
        System.out.printf("%40s\n",str1);
        System.out.printf("**%-10s**\n",str1);
        
        //문자열에서 + 연사자는 나열의 의미한다(+만 가능하다)
        System.out.println(str1+str2);
        
        
	}

}