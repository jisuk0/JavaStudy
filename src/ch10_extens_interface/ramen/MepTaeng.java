package ch10_extens_interface.ramen;

public class MepTaeng extends Ramen {

	public MepTaeng(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void printRecipe() {
		System.out.println("끓는물에 면괏프를넣고4분후에두세요");
		System.out.println("팁.물은550미리");
		
	}

}
