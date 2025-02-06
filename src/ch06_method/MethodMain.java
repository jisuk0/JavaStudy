package ch06_method;

/**
 * class Name   : MethodMain
 * Author       : Jisuk
 * Created Date : 2025. 1. 31.
 * Version      : 1.0
 * Purpose      : java 기초
 * Description  : java 함수 (클래스에 종속되어 있는 method)
 */
public class MethodMain {
	// main 메소드 public 이며 static 하여 어디서든 사용가능하고
	// void 라 리턴이 없으며 매개변수 한개 String [] 배열타입
	public static void main(String[] args) {
		System.out.println(returnSum(1, 50));
		int result = returnSum(2, 4);
		System.out.println(result);
		print("hi");
		print(factorial(15));
	}
	//2개의 정수를 입력받아 리턴없이 출력하는 함수
	public static void printSum(int from, int to) {
		int sum = 0;
		for(int i = from; i <= to; i ++) {
			sum += i;
		}
		System.out.printf("from: %d 부터 to: %d 까지 합은: %d \n", from, to, sum);
	} 
	
	public static int returnSum(int from, int to) {
		int sum = 0;
		for(int i = from; i <= to; i ++) {
			sum += i;
		}
		return sum;
	}
	public static void print(String msg) {
		System.out.println(msg);
		
	}
	public static void print(double msg) {
		System.out.println(msg);
		
	}
	
	//팩토리얼 메소드
	//input: int
	//output: long
	//method name: factorial
	public static long factorial(int num) {
		long result1 = 1;
		for (int i = 1; i <= num; i++) {
			result1 *= i;
		}
		return result1;
		
	}
}
