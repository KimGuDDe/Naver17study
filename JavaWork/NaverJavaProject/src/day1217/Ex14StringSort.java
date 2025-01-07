package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"장원영","안유진","손석구","정우성","배다혜","Denny"};
		//이름의 오름차순으로 출력
		
		for(int i=0;i<names.length-1;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				if(names[i].compareTo(names[j])<0)
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
	
		for(int i=0;i<names.length;i++)
		{
			System.out.println(i+":"+names[i]);
		}
	
	}
	

}
