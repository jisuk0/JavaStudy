package ch05_conditonal;

import java.util.Scanner;

/**
 * class Name   : WhileLoop
 * Author       : Jisuk
 * Created Date : 2025. 1. 24.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 반복문 while
 */
public class WhileLoop {
	public static void main(String[] args) {
		//while(조건식) 조건식이 true이면 반복(주의 무한루프)
		int i = 1;
		while(i <= 10) {
			System.out.println(i);
			i++;
		}
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("=============");
			System.out.println("이름을 입력하세요 (종료q)");
			String nm = scan.nextLine();
			if(nm.equals("q")) {
				flag = false;
			}
			else {
				System.out.println(nm + " 님 환영합니다");
			}
			System.out.println("=============");
		}
		while(true) {
			System.out.println("=============");
			System.out.println("이름을 입력하세요 (종료q)");
			String nm = scan.nextLine();
			if(nm.equals("q")) {
				break;
			}
			else {
				System.out.println(nm + " 님 환영합니다");
			}
			System.out.println("=============");
		}
		
		//while문으로 구구단
		//1. 단 2-9단 while문 작성
		//2. 1-9수에 해당하는 while문 작성
		//ex) 변수의 scope를 잘 생각하세요(반복되는 단 마다 수는 1로 초기화)
		/*int dan = 2;
		while (dan <= 9) {
			int i2 = 1;
			while (i2 <= 9) {
				System.out.printf("%d X %d = %d \n", dan, i2, dan*i2);
				i2++;
			}
			System.out.println("");
			dan++;
		} */
	}

}
