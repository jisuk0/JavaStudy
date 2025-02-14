package ch15_inout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * class Name   : FileInOut
 * Author       : Jisuk
 * Created Date : 2025. 2. 13.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : 파일 바이트 in out
 */
public class FileInOut {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String fileNm = "delay.txt";
		System.out.println(path + System.lineSeparator() + fileNm);
		File textFile = new File(path + "\\" + fileNm);
		try {
			//true는 파일이 있으면 append, false는 다시씀
			FileOutputStream fos = new FileOutputStream(textFile, false);
			fos.write("팽수 늦음\n".getBytes());
			fos.write("동길 늦음\n".getBytes()); //input, outputStream은 1 byte	 처리함
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//파일 읽기
		try {
			FileInputStream fls = new FileInputStream(textFile);
			byte[] data = new byte[fls.available()];
			while(true) {
				int x = fls.read(data);
				if(x == -1) {
					break;
				}
				String result = new String(data);
				System.out.println(result);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
