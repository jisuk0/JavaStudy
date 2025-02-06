package ch05_conditonal;

import java.util.Scanner;

/**
 * class Name   : conditonalEx
 * Author       : Jisuk
 * Created Date : 2025. 1. 23.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 연습문제
 */
public class conditonalEx {

	public static void main(String[] args) {
		/* 사용자로 부터 숫자를 입력받아 짝수인지 홀수인지 판단하시오.
		 * 조건1: 정수만 입력받음.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요(정수)");
		System.out.println(">>>");
		//if문을 사용하여 짝수면 "짝수", 홀수면 "홀수"를 출력하시오.
		//1. 입력받음 (형변환 int로)
		//2. 조건식 if, 연산자 operator 사용
		//3. 출력
		String userInput = scan.nextLine();
		int inputInt = Integer.parseInt(userInput);
		if (inputInt % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
	}

}
