package Day1224;

import java.util.List;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Ex10ListVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new Vector<String>();//기본 10개 할당
		List<String> list2 = new Vector<String>(5);	//기본 5개 할당
		
		System.out.println("list1 의 데이터 갯수" + list1.size()+",할당 갯수 :"
		+((Vector<String>)list1).capacity()); // capacity()메서드는 오버라이드 메서드가 아님
		System.out.println("list2 의 데이터 갯수" + list2.size()+",할당 갯수 :"
				+((Vector<String>)list2).capacity());
		
		list2.add("장원영");
		list2.add("안유진");
		list2.add("고민시");
		list2.add("안유진");
		list2.add("김태리");
		list2.add("김채원");
		
		System.out.println("list2 의 데이터 갯수" + list2.size()+",할당 갯수 :"
				+((Vector<String>)list2).capacity());
		System.out.println("출력 방법 1");
		for(String s:list2)
			System.out.println(s+" ");
		System.out.println();
		System.out.println("출력 방법 2");
		for(int i=0;i<list2.size();i++) {
			System.out.println(i+1+":"+list2.get(i)+" ");
		}
		System.out.println("출력 방법 3");
		java.util.Iterator<String> iter = list2.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()+" ");
		System.out.println("출력 방법 4");
		Object []ob=list2.toArray();
		for(Object s:ob)
			System.out.println(s+" ");
	}

}
