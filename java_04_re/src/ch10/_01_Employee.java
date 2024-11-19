package ch10;

public class _01_Employee {
	private String name;
	private String position;
	private String address;


	public _01_Employee(String name, String department, String address) {
		this.name = name;
		this.position = department;
		this.address = address;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		String str = "";

		str += "<<< " + name + " >>>\n";
		str += "포지션은 " + position + "이고, \n";
		str += address + "에 살고있습니다.\n";

		return str;
	}
}
