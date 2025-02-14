package ch15_inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Diary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("오늘의 기록(q 종료)");
		while (true) {
			String message = scan.nextLine();
			if(message.equalsIgnoreCase("q")) {
				System.out.println("종료");
				break;
			}
			myDiary(message);
		}
	}
	//input : string 내용
	//output: void
	//내용을 입력받아서 해당 날짜의 20250213.txt 파일에 내용이 기록되는 메소드 작성
	//(단 동일한 날짜라면 계행되고(\n) append 되도록
	//myDiary("오늘은 조용핟..."); (폴더는 워크스페이스 아래 diary 폴더에, 없다면 생성

	private static void myDiary(String msg) {
		String path = System.getProperty("user.dir");
		String baseDirPath = path + "\\classMate";
		File baseDir = new File(baseDirPath);
		if (!baseDir.exists()) {
			baseDir.mkdir(); //디렉토리가 없으면 생성
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currentDate = sdf.format(new Date());
		File file = new File(baseDirPath + "\\" + currentDate + ".txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
			fos.write((currentDate + "오늘의 지각자..\n").getBytes());
			fos.write((msg + "\n").getBytes());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	//1. 폴더가 없다면 생성
	//2. root 경로 + diary + 해당 날짜.txt file객체 인스턴스화
	//3. 사용자 메세지 write(append)
	//4. 종료

}
