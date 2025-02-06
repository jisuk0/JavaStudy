package ch04_operator;

import java.util.Scanner;

/**
 * class Name   : OperatorEx
 * Author       : Jisuk
 * Created Date : 2025. 1. 23.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 연산자 연습문제
 */
public class OperatorEx {

	public static void main(String[] args) {
		//사용자에게 이메일 주소를 입력받으세요
		//email 형식이 아니면 "이메일 형식이 아닙니다!"
		//email 형식이면 "사용가능"을 출력 (기준은 @ 포함 여부)
		Scanner scan = new Scanner(System.in);
		System.out.println("email 주소를 입력하세요.");
		System.out.println(">>>");
		//1. 입력받기
		String userEmail = scan.nextLine();
		//2. email 형식 체크 (ex: 문자열 함수에서 특정 문자열 인덱스를 가져오는 !?)
		String emailCheck = (userEmail.indexOf("@") == -1) ? "다시 적으세요" : "all good"; 
		//3. 메세지 출력
		System.out.println(emailCheck);
	}

}
