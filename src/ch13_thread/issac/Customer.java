package ch13_thread.issac;

public class Customer extends Thread{
	private Issac issac = Issac.getInstance();
	private String name;
	private int count;
	
	public Customer(String name, int count) {
		this.name = name;
		this.count = count;
		System.out.println(name +" 주문!");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	
}
