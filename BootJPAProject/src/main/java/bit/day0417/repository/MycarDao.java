package bit.day0417.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {
	
	MycarRepository mycarRepository;
	
	public Long getTotalCount()
	{
		return mycarRepository.getTotalMycount();
	}
	
	public void insertCar(MycarDto dto)
	{
		//save 메서드는 기본 제공 메서드. 추가 수정 모두 담당
		//num 값이 dto 포함인 경우 자동 수정 없을 경우 추가.
		mycarRepository.save(dto);
	}
	
	public List<MycarDto> getAllCarList()
	{
		return mycarRepository.findAll(); // 추가한 순서대로
		// return mycarRepository.findAll(Sort.by(Sort.Direction.DESC,"carprice")); // 단가의 내림차순을 정렬해서 출력
		// return mycarRepository.findAll(Sort.by(Sort.Direction.ASC,"carprice")); // 단가의 오름차순을 정렬해서 출력
		// return mycarRepository.findAll(Sort.by(Sort.Direction.DESC,"carguip")); // 구입일의 내림차순을 정렬해서 출력
	}
	
	//페이지에 필요한 만큼마 가져가는 메서드
	public Page<MycarDto> getAllPageCars(Pageable pageable)
	{
		return mycarRepository.findAll(pageable); //페이지에 필요한만큼만 데이터 반환
	}
	
	public MycarDto getData(Long num)
	{
		return mycarRepository.getReferenceById(num);
	}
	
	public void updateCar(MycarDto dto)
	{
		mycarRepository.save(dto); // 이번에는 num 포함이라 수정 가능
	}
	
	public void deleteCar(Long num)
	{
		mycarRepository.deleteById(num);
	}
	
	//search
	public List<MycarDto> getSearchList(String search)
	{
		return mycarRepository.getsearchList(search);
	}
	
	public List<MycarDto> findByCarnameContaining(String search)
	{
		return mycarRepository.findByCarnameContaining(search);
	}
	
}
