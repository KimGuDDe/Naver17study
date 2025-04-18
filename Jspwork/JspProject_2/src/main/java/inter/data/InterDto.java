package inter.data;

import java.sql.Timestamp;

public class InterDto {
	private int num;
	private String iname;
	private Timestamp writeday;
	private String imessage;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public String getImessage() {
		return imessage;
	}
	public void setImessage(String imessage) {
		this.imessage = imessage;
	}
	
	
}


