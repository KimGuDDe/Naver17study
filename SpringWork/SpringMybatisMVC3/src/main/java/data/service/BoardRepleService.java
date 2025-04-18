package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardRepleDto;
import data.mapper.BoardRepleMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardRepleService {
	
	BoardRepleMapper repleMapper;
	
	public void insertReple(BoardRepleDto dto) {
        repleMapper.insertReple(dto);
    }

    public List<BoardRepleDto> getReples(int idx) {
        return repleMapper.getReples(idx);
    }

    public void deleteReple(int num) {
        repleMapper.deleteReple(num);
    }
	
    public BoardRepleDto getRepleByNum(int num) {
        return repleMapper.getRepleByNum(num);
    }
    
    public void updateReple(BoardRepleDto dto) {
        repleMapper.updateReple(dto);
    }
}
