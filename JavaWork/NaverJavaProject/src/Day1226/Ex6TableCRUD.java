package Day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame {
	
	DefaultTableModel tablemodel; //추가,삭제 등의 메소드를 갖고 있는 클래스 모델
	JTable table;
	List<Student> list = new ArrayList<Student>();
	static final String FILENAME="d:/naver1210/student.txt";
	JTextField tfname,tfkor,tfeng;
	JButton btnAdd;
	
	public Ex6TableCRUD()
	{
		super("학생관리");
		this.setBounds(300,100,400,400);
		
		this.initDesign();
		this.setVisible(true);
		
		//윈도우 x버튼 클릭 시 이벤트 발생 후 파일 저장
		//익명 내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// list 의 내용을 파일에 저장
				saveFile();
				//프로그램 종료
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	
	public void writeTableData()
	{
		//기존의 테이블에 출력된 데이터 삭제 후 다시 추가
		tablemodel.setRowCount(0);
				
		for(Student stu:list)
		{
			Vector<String> data = new Vector<String>();
			int kor = stu.getKor();
			int eng = stu.getEng();
			int sum = kor + eng;
			double avg = sum/2.0;
			
			data.add(stu.getName());
			data.add(String.valueOf(kor));
			data.add(String.valueOf(eng));
			data.add(String.valueOf(sum));
			data.add(String.valueOf(avg));
			
			//table 에 추가
			tablemodel.addRow(data);
		}
	}
	
	public void initDesign()
	{//파일을 읽어온다
		this.studentFileRead();
		
		//테이블을 생성해서 center 에 추가
		String []title= {"이름","국어","영어","총점","평균"};
		tablemodel = new DefaultTableModel(title,0); //일단 행갯수는 0으로 생성
		table = new JTable(tablemodel);
		
		//talbe에 데이터 추가하기
		this.writeTableData();
		
		//frame 에 추가
		this.add("Center",new JScrollPane(table));
		
		//입력부분 디자인
		JPanel panel = new JPanel();
		tfname = new JTextField(5);
		tfkor = new JTextField(3);
		tfeng = new JTextField(3);
		
		btnAdd = new JButton("추가");
		//panel 에 각 컴포넌트들 추가
		
		//버튼 클릭 시 이벤트 발생
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력한 데이터를 읽어서 Student 에 넣어서 다시 list에 추가
				String name=tfname.getText();
				int kor = Integer.parseInt(tfkor.getText());
				int eng = Integer.parseInt(tfeng.getText());
				
				Student stu = new Student(name,kor,eng);
				list.add(stu);
				
				//table 다시 출력
				writeTableData();
				
				//입력 데이터 지우기
				tfname.setText("");
				tfkor.setText("");
				tfeng.setText("");
				
			}
		});
		
		panel.add(new JLabel("이름"));
		panel.add(tfname);
		panel.add(new JLabel("국어"));
		panel.add(tfkor	);
		panel.add(new JLabel("영어"));
		panel.add(tfeng);
		panel.add(btnAdd);
		//frame 에 panel 을 상단에 추가하자
		this.add("North",panel);
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
	
	public void saveFile( ) //List의 내용을 파일에 저장한다
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			
			for(Student stu : list)
			{
				String s= stu.getName()+"|"+stu.getKor()+"|"+stu.getEng()+"\n";
				//파일에 저장
				fw.write(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6TableCRUD();
	}

}
