package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Result03 {
	// Q1
	public static void main(String[] args) {
		ArrayList<Integer> weekLotto = null;
		weekLotto = makeLotto();
		System.out.println(weekLotto.toString());
	}

	public static ArrayList<Integer> makeLotto() {
		ArrayList<Integer> lotto = new ArrayList<>();
		while (lotto.size() < 6) {
			int num = (int) ((Math.random() * 45) + 1);
			lotto.add(num);
			Collections.sort(lotto);
		}
		return lotto;
	}

}
