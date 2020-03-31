package ver04;

import java.io.Serializable;

import ver04.Account;

abstract class Account implements Serializable{
	private String accountNumber;
	private String name;
	private int balance;
	
	public Account(String accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
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
	public int getRate() {
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Account acc = (Account)obj;
		if(acc.accountNumber.equals(this.accountNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	public  void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------");
		System.out.println("계좌번호:"+ accountNumber);
		System.out.println("고객이름:"+ name);
		System.out.println("잔고:"+ balance);
	}
}
