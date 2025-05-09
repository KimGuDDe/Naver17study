package Day1218;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		System.out.println(date);//결과값 : Wed Dec 18 15:55:31 KST 2024
		System.out.println();
		
		//내가 원하는 포맷양식으로 출력
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		SimpleDateFormat sdf3= new SimpleDateFormat("yyyy년 MM월dd일 HH:mm EEE");
		SimpleDateFormat sdf4= new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		
		int num1=45678900;
		int num2=34567;
		
		NumberFormat nf1=NumberFormat.getInstance();
		System.out.println("num1 : "+nf1.format(num1));
		System.out.println("num2 : "+nf1.format(num2));
		
		System.out.println("￦"+nf1.format(num1));
		
		NumberFormat nf2=NumberFormat.getInstance();
		System.out.println("num1 : "+nf2.format(num1));
		System.out.println("num2 : "+nf2.format(num2));
	}

}
