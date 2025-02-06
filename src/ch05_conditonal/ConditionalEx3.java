package ch05_conditonal;

import java.util.Iterator;

public class ConditionalEx3 {

	public static void main(String[] args) {
		//거꾸로 트리 5층 만들기
		/*
		 * 
		 *   *****
		 *   ****
		 *   ***
		 *   **
		 *   *
		 *   
		 */
		
		// 중첩 for문
		/*for (int i = 0; i < 5; i++) {
			for (int j = 4; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
		*/
		for (int i = 0; i <6; i++) {
			for (int j = 0; j<i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(i);
			}
			System.out.println("");
		}
	}
	
}