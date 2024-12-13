public class Apple
{


         public static void main(String[]args)
         {

                   System.out.println(args[0]);//args의 0번 배열값을 출력
                   System.out.println(args[1]);//args의 1번 배열값을 출력


                   System.out.println("두수를 더해보자");
                   System.out.println(args[0]+args[1]);//args[]는 문자열로 출력이기에 더해지지 않음

                   //문자열을 계산을 하기 위한 숫자로 변환하려면 Integer.parseInt를 사용한다
                   int su1=Integer.parseInt(args[0]);
                   int su2=Integer.parseInt(args[1]);
		   System.out.println("두 수의 합은"+(su1+su2)+"입니다.");



                   int value;
                   value=7;
                   int result=value+123;
                   System.out.println(result);



         }

}