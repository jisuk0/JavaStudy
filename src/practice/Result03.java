package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Result03 {
	// Q1
	public static void main(String[] args) {
		String [] userNum = {"2", "12"};
		System.out.println(makeLotto(userNum));
	}
	public static ArrayList<Integer> makeLotto() {
		ArrayList<Integer> numbers = new ArrayList<>();
		String [] arr = new String[0];
		numbers = makeLotto(arr);
		return numbers;
	}
	public static ArrayList<Integer> makeLotto(String [] arr) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			numbers.add(Integer.parseInt(arr[i]));
		}
		while(numbers.size() < 6) {
			int lotto = (int)(Math.random()*45 + 1);
			boolean isEqual = false;
			for (int i =0; i < numbers.size(); i++) {
				if(lotto == numbers.get(i)) {
					isEqual = true;
					break;
				}
			}
			if(!isEqual) {
				numbers.add(lotto);
			}
		}
		return numbers;
	}

}
