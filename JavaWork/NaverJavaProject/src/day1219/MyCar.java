package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar {
	private String carName;
	private int carPrice;
	private String buyDay;
	private String carColor;

	public MyCar()
	{
		//생성되는 시간을 buyDay 를 구해서 넣어보자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		buyDay = sdf.format(new Date());

		carColor = "흰 색";
	}

	public MyCar(String carName, int carPrice, String carColor) {
		super(); //super()는 지워도 되고 놔둬도 됨
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
		buyDay = sdf.format(new Date());
		
		this.carName = carName;
		this.carPrice = carPrice;
		this.carColor = carColor;
	}

	@Override //어노테이션(없어도 되는건데 부모가 가진 메소드와 동일한)
	public String toString() {
		return "MyCar [carName=" + carName + ", carPrice=" + carPrice
				+ "\n, buyDay=" + buyDay + ", carColor=" + carColor
				+ "]";
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getBuyDay() {
		return buyDay;
	}

	public void setBuyDay(String buyDay) {
		this.buyDay = buyDay;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	
	
	
	
	
}	
