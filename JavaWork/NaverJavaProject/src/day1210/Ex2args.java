package day1210;

public class Ex2args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println("안녕하세요!");
           System.out.println("Hi!");
           
           int value;
           value = 7;
           int result;
           result = value + 10;
           System.out.println(result);
           
           System.out.println("Fisrt Num"+args[0]);
           System.out.println("Secong Num"+args[1]);
         
           int su1 = Integer.parseInt(args[0]);
           int su2 = Integer.parseInt(args[1]);
           
           System.out.println(su1+su2);
           
           int score = 90;
           
	}

}
