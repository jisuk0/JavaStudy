package ch05_conditonal;

public class ConditionalMain {

	public static void main(String[] args) {
		int score = 85;
		String grade = "";
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else {
			grade = "C";
		}
		System.out.println(score + "는 " + grade);
		
		//변수의 scope
		int price = 3000;
		int myMoney = 1000;
		String msg = "";
		if(price > myMoney) {
			System.out.println("돈이 부족합니다");
			msg = "돈이 부족합니다";
		} else {
			System.out.println("돈이 충분합니다");
			msg = "돈이 충분합니다";
		}
		System.out.println(msg);
		
		//중첩 if 가능 if문 안에 if문
		//조건 1: 이름은 1글자 이상
		//조건 2: 전화번호는 10 or 11자리
		//조건1이 만족 하지 않으면 가입실패
		String nm = "닉";
		String phone = "0101234567";
		//조건1
		if(nm.length() >= 1) {
			//조건2 || <-- or의 의미
			if(phone.length() == 10 || phone.length() == 11) {
				System.out.println("Welcome!");
			} else {
				System.out.println("Fail");
			}
		}else {
			System.out.println("Fail");
		}
	}
	
}
