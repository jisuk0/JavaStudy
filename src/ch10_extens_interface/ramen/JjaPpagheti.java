package ch10_extens_interface.ramen;

public class JjaPpagheti extends Ramen{

	public JjaPpagheti(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void printRecipe() {
		// TODO Auto-generated method stub
		System.out.println("끓는 물에 며ㅑㄴ을 ㄴㅁㅇㅁㄴㅇㄴㅁㅇ");
		System.out.println("tip. 스프럴머랭랜ㅇㄹ");
		
	}

}
