package ch11_java_api;

import java.text.ParseException;

import ch12_exception.BizException;
import ch12_exception.ExMethod;

public class ExceptionMain {
	public static void main(String[] args) {
		System.out.println("메인 시작");
		int [] arr = {1, 2, 3};
		try {
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 문제!");
		} catch (NullPointerException e) {
			System.out.println("널이다");
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("오류가 나도 안나도 여긴 처리됨");
		}
		
		
		
		//throws 메소드 호출하는 쪽으로 예외처리해야함
		try {
			ExMethod.dateMillSec("2025/01/01");	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//예외처리가 되어있는 메소드
		ExMethod.dateMillSec2("2025/01/01");
		
		try {
			ExMethod.PrinterName("");
		} catch (BizException e) {
			// TODO: handle exception
			System.out.println(e.getErrCode()); //BizException 클래스 메소드
			System.out.println(e.getMessage()); //부모(Exception) 메소드
		}
		
		try {
			ExMethod.PrinterName("");
		} catch (BizException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("메인 종료");
	}
}
