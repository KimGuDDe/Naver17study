
package day1211;

public class Ex5DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char ch1='a';
        char ch2='가';
        //자바에서 char(캐릭터)타입은 2byte다(한글 한글자도 저장 가능)
        System.out.println("ch1="+ch1);
        
        System.out.println("ch2="+ch2);
        
        //printf로 출력 시 변환기호 1글자 : %c, 문자열 : %s
        
        System.out.printf("ch1=%c\tch2=%c\n",ch1,ch2);
        System.out.printf("ch1=%c\tch2=%c\n",(int)ch1,(int)ch2);
        //ascii(아스키) code로 변환되서 출력
        
        int a = 65;
        System.out.println(a);
        System.out.println(a+32);
        System.out.println((char)a);
        System.out.println((char)(a+32));
        
        //printf를 이용해서 출력해보자
        System.out.printf("%c,%c,%c,%c\n",a,a+2,a+33,a+48);
        
        //ascii code로 Hello 만들어보자
        
        System.out.printf("%c%c%c%c%c\n",(char)a+7,(char)a+36,(char)a+43,(char)a+43,(char)a+46);
        
        
        System.out.printf("ch1=%c\tch2=%c\n",ch1,ch2);
        System.out.printf("ch1=%c\tch2=%c\n",(int)ch1,(int)ch2);
	}

}