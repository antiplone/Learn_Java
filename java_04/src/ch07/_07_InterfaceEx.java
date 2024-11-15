package ch07;

public class _07_InterfaceEx {

	public static void main(String[] args) {
		First first = new First();

//		Second second = new Second();
//		first.method1(second);

		first.method1(new Second());
//		second.method2(new Third());

//		first.method1(new Second(), new Third());

//		Third third = new Third();
//		first.method1(third);

	}
}

class First/* extends Second */{

	public void method1(Second second/*, Third third*//*, Forth forth*/) {
		System.out.println("First - method1()");

//		Second second = new Second();
//		super.method2();
	
//		Third third = new Third();
//		second.method2(third);

		second.method2(new Third());
	}
}

class Second {

	public void method2(Third third/*, Forth forth*/) {
		System.out.println("Second - method2()");

//		Third third = new Third();
//		third.method3();

		third.method3(new Fourth());
	}
}

class Third {

	public void method3(Fourth fourth) {
		System.out.println("Third - method3()");
		fourth.method4();
	}
}

class Fourth {

	public void method4() {
		System.out.println("Fourth - method4()");
	}
}
