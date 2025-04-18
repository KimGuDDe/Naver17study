package bit.day0417.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bit.day0417.data.MycarDto;
import bit.day0417.repository.MycarDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MycarService {
	
	MycarDao mycarDao;
	
	public long getTotalCount()
	{
		return mycarDao.getTotalCount();
	}
	
	public void insertCar(MycarDto dto)
	{
		mycarDao.insertCar(dto);
	}
	
	public List<MycarDto> getAllCarList()
	{
		return mycarDao.getAllCarList();
	}
	
	public MycarDto getData(Long num)
	{
		return mycarDao.getData(num);
	}
	
	public void updateCar(MycarDto dto)
	{
		mycarDao.updateCar(dto); // 이번에는 num 포함이라 수정 가능
	}
	
	public void deleteCar(Long num)
	{
		mycarDao.deleteCar(num);
	}
}
