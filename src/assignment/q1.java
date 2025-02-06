package assignment;

import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("국어 점수를 입력하세요");
		System.out.println(">>>");
		String userScore1 = scan.nextLine();
		int userKorScore = Integer.parseInt(userScore1);
		System.out.println("영어 점수를 입력하세요");
		System.out.println(">>>");
		String userScore2 = scan.nextLine();
		int userEngScore = Integer.parseInt(userScore2);
		System.out.println("수학 점수를 입력하세요");
		System.out.println(">>>");
		String userScore3 = scan.nextLine();
		int userMathScore = Integer.parseInt(userScore3);
		double averageScore = (userEngScore+userKorScore+userMathScore)/3f;
		System.out.printf("평균: %f", averageScore);
		System.out.println("");
		if (averageScore >= 90) {
			System.out.println("등급: A 등급");
		}
		else if (averageScore>= 80) {
			System.out.println("등급: B 등급");
		}
		else {
			System.out.println("등급: C 등급");
		}
	}

}
