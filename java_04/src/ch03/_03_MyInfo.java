package ch03;

//AI서비스_웹과정반 @6일차
public class _03_MyInfo {
	/* 멤버변수(속성) */
	private String	name;
	private String	birthday;
	private int		money;
	private String	address;

	/* 멤버메서드(기능) */
	/* setter */
	public void setName(String name) {
		this.name = name;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	/* 출력정보 */
	public void printInfo() {
		System.out.println("이름:\t" + this.name);
		System.out.println("생일:\t" + this.birthday);
		System.out.println("재산:\t" + this.money);
		System.out.println("주소:\t" + this.address);
	}
}
