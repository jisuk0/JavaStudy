package ch10_extens_interface.papacar;

public class ElectricCar implements Vehicle {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("슈우우우웅~");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("---");
	}

}
