package ch06_method;

import java.util.Scanner;

public class MethodEx2 {

	public static void main(String[] args) {
		// coffee shop method를 만들어 주세요
		// input: 고객수
		// output: 없음
		
		//고객수만큼 커피 주문을 받아 금액을 출력하는 메소드
		
		//아아 아메리카노: 3000, 카푸치노: 4500, 밀크티: 5000
		//메뉴가 없으면 '메뉴가 없습니다. 출력 후 다시 주문 받아야함.'
		//n명 고객 주문완료
		//총 주문 금액: m 원
		coffeeShop(3);
	}
	//1. 메소드 선언
	public static void coffeeShop(int cusNum) {
	//2. 인원수 만큼 반복
	//3. 사용자 입력에 따른 음료의 가격 조건문
	//4. 조건에 해당되는 음료가 있을때 가격합산 (해당 메소드 전역적으로 합산관련 변수 사용)
	//5. 인원수에 따른 주문이 완료되면 합산 출력
		int i = 1;
		//int price = 0;
		while (i<cusNum) {
			System.out.printf("%d번쨰 고객님 어떤걸 드릴까요? \n", i);
			int price = 0;
			Scanner scan = new Scanner(System.in);
			String userInput = scan.nextLine();
            switch (userInput) {
			case "아아":
				System.out.println("선택하신 메뉴는 3000원입니다.");
                price += 3000;
                i++; 
				break;
			case "아메리카노":
				System.out.println("선택하신 메뉴는 3000원입니다.");
                price += 3000;
                i++; 
				break;
			case "카푸치노":
				System.out.println("선택하신 메뉴는 4500원입니다.");
                price += 4500;
                i++; 
				break;
			case "밀크티":
				System.out.println("선택하신 메뉴는 5000원입니다.");
                price += 5000;
                i++; 
				break;

			default:
				System.out.println("없는 메뉴입니다. 다시 주문해주세요.");
				break;
			}
    		System.out.printf("%d명의 고객 주문완료 \n", i-1);
    		System.out.println("총 주문 금액: " + price + "원");
		}


		
	}

}
