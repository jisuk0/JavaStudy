package ch15_inout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * class Name   : FileBasic
 * Author       : Jisuk
 * Created Date : 2025. 2. 13.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 파일 입출력(문자단위)
 */
public class FileBasic {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		//현재경로
		System.out.println(path);
		FileReader reader = null;
		FileReader writer = null;
		
		try {
			reader = new FileReader(path + "/delay.txt");
			writer = new FileReader(path + "/delay_backup.txt");
			char [] data = new char[16];
			while(true) {
				int x = reader.read(data);
				if(x == -1) {
					System.out.println("파일 끝에 도달");
					break;
				}
				writer.write(data, 0, x);
			}
			writer.flush();
			System.out.println("파일 쓰기 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null)writer.close();
				if(reader != null)reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
