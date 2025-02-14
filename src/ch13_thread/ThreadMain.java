package ch13_thread;

import java.util.Iterator;

public class ThreadMain {

	public static void main(String[] args) {
		System.out.println("main");
		//1. Thread 상속 받아서 사용
		ExThread job1 = new ExThread(20, "job1");
		job1.start(); //run 메소드 사용
		ExThread job2 = new ExThread(100, "job2");
		job2.start();
		System.out.println("main end");
		
		//2. Runnable 인터페이스 구현 클래스 사용
		ExRunnable exRun1 = new ExRunnable(300, "job3");
		Thread job3 = new Thread(exRun1);
		job3.start();
		System.out.println("main end");
		
		//3. 람다식 사용(익명함수)
		Thread job4 = new Thread(() -> {
			int num = 600;
			for(int i = num; i <= num + 5; i++) {
				System.out.println("job4" + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

	}
	
	public static void print(int num) {
		for(int i = num; i <= num + 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
