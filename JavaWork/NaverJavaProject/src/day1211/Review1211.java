package day1211;

public class Review1211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		//byte
		
		byte a1 = 120;
	    byte a2 = (byte)129; //byte(바이트)는 최대 128까지 가능하다. 그 이상은 에러로 간주
	    //128 이상의 숫자를 강제로 표기하려면 (byte)@@@으로 표기해야만 한다.
	    
	    System.out.println(a1);
	    System.out.println(a2);
	    
	    //결과값 : 120 , -127
	    
	    //float 와 double
	    //float는 4바이트, double은 8바이트. double이 표기할 수 있는 숫자가 많다.
	    
	    float b1 = 3.45f; // float는 뒤에 f를 붙여야 4바이트 float가 인식된다. 그냥은 double로만.
	    double b2 = 3.45;
	    
	    System.out.println("결과값 :" + b1);
	    System.out.println("결과값 :" + b2);
	    
	    //결과값 : 결과값 :3.45, 결과값 :3.45
	    
	    //printf으로 만드는 0000-00-00
	    
	    int year = 2024;
	    int month = 1;
	    int day = 1;
	    
	    System.out.println(year +"-"+month+"-"+day); // 결과값 : 2024-1-1	    
	    //println은 0000-00-00이 안된다
	    
	    System.out.printf("%d-%02d-%02d\n",year,month,day); //결과값 : 2024-01-01
	    //0000-00-00으로 만들고 싶다면 -> %02d를 사용
	    
	    //printf를 이용한
	   
	    
	    int money = 100000;
	    
	    System.out.printf("금액"+"%20d원\n",money);  //결과값 : 금액              100000원
	    System.out.printf("금액"+"%-10d원\n",money); //결과값 : 금액100000    원
	    
	    //%20d는 결과값 앞에 20자리 수만큼 띄워놓는 것
	    //%-10d는 결과값 뒤에 10자리 수만큼 띄워놓는 것
	    
	    char c1 = 'b';
        char c2 = 'a';
        
        System.out.println((char)(c1+c2));
        
        String c3 = "a";
        String c4 = "b";
        
        System.out.println(c3+c4);
        
        
	    
	    		
	    
	    
	    
	    		
	    		
	 
	   
	   
	    
	    
	}

}
