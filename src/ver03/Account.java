package ver03;

abstract class Account {
	String accountNumber;
	String name;
	int balance;
	int numOfAcc;
	Account[] acc = new Account[50];
	
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
	public int getCreditRateing() {
		return 0;
	}
	public Account(String accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getRate() {
		return 0;
	}
	public  void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------");
		System.out.println("계좌번호:"+ accountNumber);
		System.out.println("고객이름:"+ name);
		System.out.println("잔고:"+ balance);
	}
}
