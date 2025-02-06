package ch07_array;

public class ArrayEx {

	public static void main(String[] args) {
		//우리반 학생들의 이름이 담긴 string [] 선언
		//shift + alt + a
		String [] students = {
				"강지석", "김도래", "김병준", "김서영", "김소연", "김원진", "박정단", "박종욱", "송은호", "신미정", "이예성", "이예은", "정지나", "최보석",
				"한수정",
		};
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
		
		//학생들의 이름에 출석부 순번을 붙여 출력해주세요
		for (int i = 0; i < students.length; i++) {
			System.out.println( (i + 1) +". " + students[i]);
		}
		
		//같은 성 찾기 메소드를 작성해주세요!
		//input: string, string[]
		//output 없음
		//호출 : searchNm("이", students);
		//출력 : "이"씨 성을 가진 학생은 총 2명 있습니다.
		//		이에성, 이예은
		SearchName("김", students);
		//1. 메소드, 리턴, 입력 비어있는 메소드 만들기
		//2. 반복문
		//3. 각 이름의 첫자리가 찾고자하는 성과 같은지 (문자열도 인덱스로 접근가능) or substring
		// 같으면 카운트 증가
		//4. 반복이 종료되고 성과 카운트 출력
	}
	
	public static void SearchName(String first, String [] arr) {
		String studentList = new String();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].startsWith(first)) {
				count++;
				studentList += arr[i] + "씨 ";
			}
		}
		System.out.println(first + "씨 성을 가진 학생은 총 " + count + " 명입니다");
		System.out.println(studentList);

		
	}
}
