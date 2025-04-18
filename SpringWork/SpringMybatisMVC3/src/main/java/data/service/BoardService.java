package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardDto;
import data.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
	BoardMapper boardMapper;
	
	public int getTotalCount()
	{
		return boardMapper.getTotalCount();
	}
	
	public int getMaxIdx()
	{
		return boardMapper.getMaxIdx();
	}
	
	public void updateRestep(int regroup, int restep)
	{
		boardMapper.updateRestep(regroup, restep);
	}
	
	public void insertBoard(BoardDto dto)
	{
		int idx=dto.getIdx();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(idx==0)
		{
			regroup=this.getMaxIdx()+1;
			relevel=0;
			restep=0;
		}else {
			this.updateRestep(regroup, restep);
			restep++;
			relevel++;
		}
		
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//db insert
		boardMapper.insertBoard(dto);
	}
	
	public List<BoardDto> getPagingList(int start,int perpage)
	{
		return boardMapper.getPagingList(start, perpage);
	}
	
	public void updateReadcount(int idx)
	{
		boardMapper.updateReadcount(idx);
	}
	
	public BoardDto getSelectByIdx(int idx)
	{
		return boardMapper.getSelectByIdx(idx);
	}
	
	public List<BoardDto> getSelectById(String myid)
	{
		return boardMapper.getSelectById(myid);
	}
	
	public void updateList(BoardDto dto)
	{
		boardMapper.updateList(dto);
	}
	
	public void deleteList(int idx)
	{
		boardMapper.deleteList(idx);
	}
}
