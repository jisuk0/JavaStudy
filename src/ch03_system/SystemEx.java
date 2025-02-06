package ch03_system;

import java.util.Scanner;

public class SystemEx {

	public static void main(String[] args) {
		/* 1. 사용자의 이름: 나이를 입력받아
		 * 이름 춤력
		 * 나이 출력
		 * 
		 * 2. 사용자의 이름: 나이를 입력받아
		 * 변수에 각각 할당 후
		 * 해당 변수로 사용자의 이름, 나이를 출력
		 * 
		 * 단) 이름의 길이가 달라질수있음
		 * 
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("이름:나이를 입력하세요");

/*
        String name = scan.next(); 
        int age = scan.nextInt();   

        System.out.println("1번 문제");
        System.out.println(name);
        System.out.println(age);
        System.out.println();
        System.out.println("2번 문제");
        System.out.println("이름: " + name + ", 나이: " + age);
*/
		String userString = scan.nextLine();
		System.out.println("==== Q1 ====");
		int idx = userString.indexOf(":");
		System.out.println(idx);
		System.out.println(userString.substring(0, idx));
		System.out.println(userString.substring(idx+1));
		
		String nm = userString.substring(0, idx);
		String age = userString.substring(idx+1);
		//콘솔입력은 String 타입
		//숫자형태로 사용하려면 casting 형변환 해야함.
		int userAge = Integer.parseInt(age);
		
		System.out.println("==== Q2 ====");
		System.out.println("이름: "+ nm +", 나이: " + age);
		System.out.println("이름: "+ nm +", 나이: " + userAge);
	}

}
