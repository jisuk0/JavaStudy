package ch10_extens_interface.family;

//child는 parent를 상속받음(extends)
public class Child extends Parent {
	
	public Child() {
		super();
	}
	
	public Child(String name, int age) {
		super(name, age);
	}

	@Override
	public void sayHello() {
		System.out.println("자식입니다.");
	}

	@Override
	public String toString() {
		return "Child [toString()=" + super.toString() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
