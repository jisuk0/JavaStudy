package ch05_conditonal;

import java.util.Scanner;

public class ConditonalEx2 {

	public static void main(String[] args) {
		//커피 주문
		//아아 or 아메리카노 : 3000
		//카푸치노 : 4500
		//밀크티 : 5000 만약 메뉴가 없으면 "메뉴 없습니다." 출력
		
		//1. 주문받기
		Scanner scan = new Scanner(System.in);
		System.out.println("어떤걸 드릴까요?");
		System.out.println("아메리카노, 카푸치노, 밀크티 ");
		String order = scan.nextLine();
		int price = 0;
		switch (order) {
			case "아메리카노":
				price = 3000;
				break;
			case "아아":
				price = 3000;
				break;
			case "카푸치노":
				price = 4500;
				break;
			case "밀크티":
				price = 5000;
				break;	
			default:
				System.out.println("메뉴 없습니다");
		}		
		if (price > 0) {
			System.out.println(order);
			System.out.println(price + "원 입니다");		
			}

		scan.close();
	}

}
