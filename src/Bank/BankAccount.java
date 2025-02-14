package Bank;

public class BankAccount {
	private int accountNumber;
	private String name;
	private int balance;
	public BankAccount(int accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getNameString() {
		return name;
	}
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("예금이 성공되었습니다.");
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("출금이 성공되었습니다.");
        } else {
            System.out.println("잔액 부족.");
        }
    }
}
