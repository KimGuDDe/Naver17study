package Day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex5TableStudent extends JFrame{
	JTable table;
	List<Student> list = new ArrayList<Student>();
	static final String FILENAME="d:/naver1210/student.txt";
	

	public Ex5TableStudent() {
		super("학생성적관리");
		this.setBounds(300,100,400,300);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void studentFileRead() {
		//파일 읽어서 list 변수에 담기
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			while(true)
			{
				String studentInfo = br.readLine();
				if(studentInfo == null)
					break;
				String []s=studentInfo.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));
//				student.setSum(Integer.parseInt(s[3]));
//				student.setAvg(Integer.parseInt(s[4]));
				
				list.add(student);
			  }
			} catch (FileNotFoundException e) {
				System.out.println("저장된 학생정보가 없습니다");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					br.close();
					fr.close();
				}catch(IOException|NullPointerException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}	
			


		public void initDesign() {
			this.studentFileRead(); //파일을 읽어서 list 변수에 담는다
			//list 데이터를 읽어서 테이블에 출력 후
			//프레임에 출력
			//제목은 이름,국어,영어,총점,평균
			String []title = {"학생명","국어점수","영어점수","총점","평균점수"};
			String [][]data = new String[list.size()][5];
			
			int i=0;
			for(Student s:list)
			{
				data[i][0]=s.getName();
				data[i][1]=String.valueOf(s.getKor());
				data[i][2]=String.valueOf(s.getEng());
				data[i][3]=String.valueOf(s.getKor()+s.getEng());
				data[i][4]=String.valueOf((s.getKor()+s.getEng())/2);
				
				i++;
			}
			table = new JTable(data,title);
			this.add("Center",new JScrollPane(table));
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Ex5TableStudent();
		}

	}
