package Day1226;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

public class CountReview2 extends JFrame{
	JTable table;
	List<CountReview1> theList = new ArrayList<CountReview1>();
	static final String FILENAME="d:/naver1210/count.txt";
	
	public CountReview2()
	{
		super("사격점수");
		this.setBounds(300,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}
	
	public void studentFileRead()
	{
		
	}
	
	public void initDesign()
	{
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
