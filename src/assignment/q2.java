package assignment;


public class q2 {

	public static void main(String[] args) {
		int n = 10;
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		System.out.println(n+ "! = " + result);
		System.out.println("");
		int n2 = 15;
		long result2 = 1;
		for (int i = 1; i <= n2; i++) {
			result2 *= i;
		}
		
		System.out.println(n2+ "! = " + result2);
	}

}
