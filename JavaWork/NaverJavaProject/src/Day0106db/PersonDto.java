package Day0106db;

public class PersonDto {
	private int num;
	private String name;
	private int age;
	private int hp;
	private String blood;
	public PersonDto(String name, int age, int hp, String blood) {
		super();
		this.name = name;
		this.age = age;
		this.hp = hp;
		this.blood = blood;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	
	
}
