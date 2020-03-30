package ver04;

import java.util.Arrays;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(acc);
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numOfAcc;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (!Arrays.equals(acc, other.acc))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (balance != other.balance)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfAcc != other.numOfAcc)
			return false;
		return true;
	}
	public  void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("-------------");
		System.out.println("계좌번호:"+ accountNumber);
		System.out.println("고객이름:"+ name);
		System.out.println("잔고:"+ balance);
	}
}
