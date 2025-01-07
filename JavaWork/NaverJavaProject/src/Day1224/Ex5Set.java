package Day1224;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set 인터페이스를 구현한 클래스로는 HashSet 과 TreeSet 이 있다
 * Set 타입의 특징 : 1. 중복 데이터를 허용하지 않는다
 * 					 2. 비순차적이다(추가한 순서대로 들어가지 않는다)
 * 					 HashSet : 임의로 정해진다, TreeSet : 오름차순으로 정해진다
 * 
 * 모든 컬렉션은 타입(Set,Map,List)은 제네릭스를 이용하여 타입 지정
 * 모든 컬렉션은 원래 오브젝트 타입만 추가되는데 jdk5 이후로
 * 오토 박싱에 의해 기본형도 자동으로 오브젝트화되서 들어간다
 */
public class Ex5Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set<Integer> set1 = new HashSet<Integer>();
		//Integer 타입 이외의 데이터를 넣을 경우 컴파일 오류 발생
		Set<Integer> set1 = new HashSet<>(); //우측의 제네릭스 부분은 타입 생략가능
		Set<Integer> set2 = new TreeSet<Integer>();
		
		set1.add(100);
		set1.add(300);
		set1.add(100);
		set1.add(200);
		set1.add(500);
		
		set2.add(100);
		set2.add(300);
		set2.add(100);
		set2.add(200);
		set2.add(500);
		
		System.out.println("set1의 개수" + set1.size()); //갯수를 알아보는 함수 size
		System.out.println("set2의 개수" + set2.size()); //결과 : 100이 중복되어서 4개라고 나옴	
		
		//컬렉션 출력 for문
		System.out.println("HashSet 결과");
		for(Integer n:set1)
			System.out.print(n+" ");
		System.out.println();
		
		System.out.println("TreeSet 결과");
		for(Integer n:set2)
			System.out.print(n+" ");
		System.out.println();
	}

}
