package Day1224;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex6Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 =new HashSet<String>();
		Set<String> set2 =new TreeSet<String>();

		set1.add("장원영");
		set1.add("안유진");
		set1.add("장원영");
		set1.add("강리나");

		set2.add("장원영");
		set2.add("안유진");
		set2.add("장원영");
		set2.add("강리나");

		System.out.println("set1의 갯수:"+set1.size());
		System.out.println("set1의 갯수:"+set2.size());

		System.out.println("HashSet으로 출력");
		for(String s :set1)
			System.out.println(s+" ");
			System.out.println();
			System.out.println("TreeSet으로 출력");
		for(String s:set2)
			System.out.println(s+" ");
			System.out.println();
			
			Iterator<String> iter=set2.iterator();
			while(iter.hasNext())
				System.out.println(iter.next()+" ");
			System.out.println();
			}
		}

	

