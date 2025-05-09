package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.ShopDto;
import data.dto.ShopRepleDto;
import data.mapper.ShopRepleMapper;
import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class ShopRepleService {
	@Autowired
	ShopRepleMapper repleMapper;
	
	public void insertShopReple(ShopRepleDto dto)
	{
		repleMapper.insertShopReple(dto);
	}
	public void deleteShopReple(int idx)
	{
		repleMapper.deleteShopReple(idx);
	}
	public List<ShopRepleDto> getRepleByNum(int num)
	{
		return repleMapper.getRepleByNum(num);
	}
	
	public String getPhoto(int idx)
	{
		return repleMapper.getPhoto(idx);
	}
	
	public void updateLikes(int idx)
	{
		repleMapper.updateLikes(idx);
	}
	public int getLikes(int idx)
	{
		return repleMapper.getLikes(idx);
	}
}
