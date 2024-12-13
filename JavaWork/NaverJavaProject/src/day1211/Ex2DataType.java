package day1211;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int kor = 90;
        int eng = 93;
        System.out.println("합계="+kor+eng);
        //String+int+int : 묵시적형변환에 의해서 String+int=String 값을 갖게 됨
        System.out.println("합계="+(kor+eng));
        //그렇기 때문에 묵시적형변환 적용을 막기 위해선 int에 괄호를 넣어 int 먼저
        //계산되도록 해야 한다 ㅇㅋ? ㅇㅋ
        
        //진법전환
        int a = 056; //앞에 0이 붙으면 8진수로 인식
        int b = 0x12a; //앞에 0x가 붙으면 16진수로 인식
        System.out.println("a="+a);//8진수를 10진수로 변경하는 법
        //5x8 + 6X1 = 40 + 6 = 46
        System.out.println("b="+b);//16진수를 10진수로 변경하는 법
        //1x16의 2승 + 2x16의 1승 + 10x16의0승 :
        int c= 047;
        int d= 0xa9;
        System.out.println("c="+c);
        System.out.println("d="+d);		
	}

}
