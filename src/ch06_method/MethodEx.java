package ch06_method;

import java.util.Scanner;

public class MethodEx {

	public static void main(String[] args) {
		// 이름, 국어함수, 수학점수, 영어점수를 입력받아
		// 평균과 등급을 출력하는 메소드를 작성하시오
		
		// input: String, int, int, int
		// output: 없음
		// method name: makeCard
		// 등급은 90 이상: A, 80 이상 B, 나머지 C
		// 출력) xxx님의 평균은 95.0으로 A등급입니다
		makeCard("팽수", 100, 90, 100);
	}
	
	public static void makeCard(String name, int kor, int math, int eng) {

		double avgScore = (kor + math + eng)/3.0;
		String grade = "C";
		if (avgScore >= 90) {
			grade = "A";
		}
		else if (avgScore >= 80) {
			grade = "B";
		}
		System.out.printf("%s 님의 평균 점수는 %.2f 으로 %s 등급입니다",name, avgScore, grade);
	}

}
