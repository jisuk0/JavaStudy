package ch07_array;

public class ArrayEx2 {

	public static void main(String[] args) {
		// Q. 월리를 찾아라
		// findWally 문자열에 '윌리'가 총 몇개 인지 출력
		String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
		String [] arr = findWally.split("");
		int cnt = 0;
		int cnt2 = 0;
		//2자리씩 비교 or 제거
		int all = findWally.length();
		int after = findWally.replaceAll("월리", "").length();
		System.out.println(all + "-" + after);
		cnt = (all + after) / 2;
		
		for (int i =0; i < findWally.length(); i++) {
			String subText = findWally.substring(i, i+1);
			if (subText.equals("월리")) {
				cnt2++;
			}
		}
		
		System.out.println("월리는 총: " + cnt);

		
	}
	
	public static void findWords(String wally, String [] arr ) { 
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].matches("월리")) {
				cnt++;
			} 
		}
		System.out.println("월리는 총: " + cnt);
	}
}
