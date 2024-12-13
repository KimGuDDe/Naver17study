package Review;

public class Review12225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b,max;
		a= 5;
		b= 15;
		
		max = a>b?a:b;
		System.out.println(max);
		
		int score;
		score = 69;
		String grade;
		
		grade = (score>=90?"우수":score>=80?"합격":score>=70?"노력":"낙제");
		
		System.out.println(grade);
		
		
		
	}

}
