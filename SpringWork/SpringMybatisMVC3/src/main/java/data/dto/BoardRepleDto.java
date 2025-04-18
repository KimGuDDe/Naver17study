package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("BoardRepleDto")
public class BoardRepleDto {
	private int num;
	private int idx;
	private String myid;
	private String message;
	private String photo;
	private Timestamp writeday;
}
