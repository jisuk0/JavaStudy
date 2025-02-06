package ch09_class.students;

import java.util.ArrayList;

public class Dictionary {
	
	//전역적으로 사용하는 상수
	public static final int OPTION_STUDENT = 0; 
	public static final int OPTION_CODING_WORD = 1; 
	public static final int OPTION_RANDOM = 2;
	
	//타자연습 게임을 위한 단어 메소드
	public static ArrayList<String> makeWordList(int option) {
		ArrayList<String> result = new ArrayList<>();
		if (option == OPTION_STUDENT) {
			result.add("kang jisuk");
			result.add("kim dorae");
			result.add("kim byeongjun");
			result.add("kim seoyeong");
			result.add("kim soyeon");
			result.add("kim wonjin");
			result.add("park jeongdan");
			result.add("park jonguk");
			result.add("song eunho");
			result.add("shin mijung");
			result.add("lee yeseong");
			result.add("lee yeeun");
			result.add("jung jina");
			result.add("choi boseok");
			result.add("han sujeong");

		} else if (option ==OPTION_CODING_WORD) {
			result.add("class");
			result.add("if");
			result.add("break");
			result.add("else");
			result.add("continue");
		} else if (option == OPTION_RANDOM) {
			// 랜덤 알파벳 6자리로 단어 생성
			String [] alphabet = "qwertyuiopasdfghjklzxcvbnm".split("");
			// 10개 담기
			for (int i = 0; i < 10; i++) {
				String word = "";
				for (int j = 0; j < 6; j++) {
					int idx = (int)(Math.random()*alphabet.length);
					word += alphabet[idx];
				}
				result.add(word);
			}
		}
		return result;
	}
	
}
