package Day0106db;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex3PersonTable extends JFrame{
	
	JTextField num,name,blood,age,hp;
	JButton btnAdd,btnDel,btnUpdate,btnSearch;
	DefaultTableModel tableModel;
	JTable table;

	PersonModel personModel = new PersonModel();
	
	public Ex3PersonTable() {
		super("직원 관리");
		this.setBounds(300,100,600,400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		p1.add(new JLabel("직원명"));
		num = new JTextField(3);
		name = new JTextField(6);
		blood = new JTextField(3);
		age = new JTextField(3);
		hp = new JTextField(10);

		p1.add(num);
		p1.add(new JLabel("번호"));
		p1.add(name);
		p1.add(new JLabel("이름"));
		p1.add(blood);
		p1.add(new JLabel("혈액형"));
		p1.add(age);
		p1.add(new JLabel("나이"));
		p1.add(hp);
		p1.add(new JLabel("핸드폰번호"));
		

		// p1 panel frame 상단에 추가하기
		this.add("North",p1);

		//frame 중간에 table 넣기
		String []title = {"번호","이름","혈액형","나이","핸드폰번호"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table)); //제목과 스크롤이 보이도록 추가

		//생성된 테이블 db데이터 출력하기
		//this.rowSelect();

		//하단 버튼 3개
		btnAdd = new JButton("직원 추가");
		btnDel = new JButton("직원 제명");
		btnUpdate = new JButton("직원 수정");
		btnSearch = new JButton("직원 검색");

		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnDel);
		p2.add(btnUpdate);
		p2.add(btnSearch);
		this.add("South",p2);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3PersonTable ex3 = new Ex3PersonTable();
	}

}
