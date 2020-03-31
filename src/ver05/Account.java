package ver05;

public class Account {
	String accountNumber;
	String name;
	int balance;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccount() {
		return accountNumber;
	}
	public String getName() {
		return name;
	}
	public Account(String accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
}
