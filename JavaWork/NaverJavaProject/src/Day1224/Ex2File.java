package Day1224;

import java.io.File;

public class Ex2File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("d/:naver1210/score.txt");
		File file2 = new File("d:/naver1210");
		System.out.println(file1.length()); //글자 길이 - 바이트 단위
		System.out.println(file1.canExecute()); //true
		System.out.println(file1.canRead()); //true
		System.out.println(file1.canWrite());//true
		System.out.println();

		System.out.println(file2.exists());
		System.out.println(file1.isDirectory());
		System.out.println(file2.isDirectory());
		System.out.println();

		System.out.println(file1.isFile());
		System.out.println(file2.isFile());

		//file1 이 디렉토리라면 목록을 출력하라
		if(file1.isDirectory())
		{
			String []list = file1.list();
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("file1 은 파일입니다");
		}

		//file2 이 디렉토리라면 목록을 출력하라
		if(file2.isDirectory())
		{
			String []list = file2.list();
			int n=0;
			for(String s:list)
				System.out.println(s);
		}else {
			System.out.println("file1 은 파일입니다");
		}
		System.out.println("=".repeat(30));
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
	}

}
