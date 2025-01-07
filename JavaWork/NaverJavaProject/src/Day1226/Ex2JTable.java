package Day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame{
	JTable table;

	public Ex2JTable() {
		super("JTable 공부");
		this.setBounds(300,100,300,300); // 시작위치, 크기 조정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 클릭 시 종료
		this.initDesign();
		this.setVisible(true);//프레임 보이게 하기
	}

	public void initDesign()
	{
		//기본 레이아웃 = BorderLayout
		//이 레이아웃 = 동서남북센터로 위치를 정하는 레이아웃
		
		//방법 1
//		String []title = {"이름","혈액형","나이"};
//		String [][]data = {
//				{"장원영","AB","21"},
//				{"안유진","A","24"},
//				{"고민시","B","28"}
//		};
		
		//방법2
		
		Vector<String> title = new Vector<String>();
		title.add("이름");
		title.add("혈액형");
		title.add("나이");
		
		Vector<String> data1 = new Vector<String>();
		data1.add("장원영");
		data1.add("AB");
		data1.add("21");
		
		Vector<Vector<String>> data = new Vector<Vector<String>>(); 
				
		//jtable 생성
		table = new JTable(data,title);
		
		//North 에 JLabel 을 추가해보자
		this.add("North",new JLabel("데이터출력테이블",JLabel.CENTER));

		//frame 의 center에 추가
		//this.add("center",table); //제목이 안나옴, 데이타가 많을 경우 스클롤도 안됌
		this.add("Center",new JScrollPane(table));//JScrollPane 으로 생성해서 넣어야 나타남
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2JTable ex2 = new Ex2JTable();

	}

}
