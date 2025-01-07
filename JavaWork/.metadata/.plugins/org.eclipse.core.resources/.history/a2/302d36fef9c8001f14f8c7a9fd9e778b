package Day1223;

// Tire 클래스 정의
public class Tire {
    public void roll() {
        System.out.println("타이어가 회전합니다");
    }
}

// HankookTire 클래스는 Tire를 상속
class HankookTire extends Tire {
    @Override
    public void roll() {
        System.out.println("한국 타이어가 회전합니다");
        // super.roll(); // 기본 회전 메소드 호출, 필요시 사용 가능
    }
}

// KumhoTire 클래스도 Tire를 상속
class KumhoTire extends Tire {
    @Override
    public void roll() {
        System.out.println("금호 타이어가 회전합니다");
        // super.roll(); // 기본 회전 메소드 호출, 필요시 사용 가능
    }
}

// Car 클래스 정의
class Car {
    public Tire tire;  // Tire 타입의 필드

    public void run() {
        tire.roll();  // 현재 할당된 타이어의 roll() 메소드 호출
    }
}

// CarExample 클래스는 main 메소드 포함
public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();  // Car 객체 생성
        
        // 타이어를 일반적인 Tire 객체로 설정
        myCar.tire = new Tire();
        myCar.run();  // Output: 타이어가 회전합니다
        
        // 타이어를 HankookTire 객체로 설정
        myCar.tire = new HankookTire();
        myCar.run();  // Output: 한국 타이어가 회전합니다
        
        // 타이어를 KumhoTire 객체로 설정
        myCar.tire = new KumhoTire();
        myCar.run();  // Output: 금호 타이어가 회전합니다
    }
}