package ch10_extens_interface.ramen;

public class RamenMain {

	public static void main(String[] args) {
		MepTaeng mep = new MepTaeng("맵탱", 1000);
		mep.printRecipe();
		JjaPpagheti jja = new JjaPpagheti("짜파게티", 1200);
		jja.printRecipe();

	}

}
