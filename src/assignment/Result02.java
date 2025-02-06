package assignment;

import java.util.Scanner;

public class Result02 {

	// Q.2 업다운 게임
	// 1 ~ 50 사이의 랜덤 정수 생성
	// 기회는 5번!
	public static void main(String[] args) {
		System.out.println("== 난수 발생 == ");
		for (int i = 0; i < 10; i++) {
			System.out.println(Math.random());// 난수 생성 메소드 0 ~ 1 사이 실수
		}
		int randInt = (int) (Math.random() * 50 + 1); // 1 ~ 50 사이 정수
		System.out.println(randInt);
		System.out.println();

		Scanner scan = new Scanner(System.in);
		int attempts = 5;
		while (attempts > 0) {
			System.out.print("숫자를 입력해주세요: ");
			int userInput = scan.nextInt();
			if (userInput < randInt) {
				System.out.println("업!! 기회" + (attempts - 1) + "번 남았습니다. ");
			} else if (userInput > randInt) {
				System.out.println("다운!! 기회" + (attempts - 1) + "번 남았습니다. ");
			} else if (userInput == randInt) {
				System.out.println("정답입니다!");
			}
			attempts--;
			if (attempts == 0) {
				System.out.println("실패하였습니다. 정답은 " + randInt + "입니다.");
			}

		}

	}
}
