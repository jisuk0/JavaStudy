package ch13_thread;

/**
 * class Name   : ExThread
 * Author       : Jisuk
 * Created Date : 2025. 2. 12.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 스레드
 */
public class ExThread extends Thread{
	
	int num;
	public ExThread(int num, String name) {
		super(name);
		this.num = num;
	}
	@Override
	public void run() {
		for(int i = num; i <= num + 5; i++) {
			System.out.println(super.getName()+ " " + i) ;
			//시간차를 두기 위해
			try {
				Thread.sleep(500); //0.5초 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
