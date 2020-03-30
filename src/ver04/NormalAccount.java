package ver04;

public class NormalAccount extends Account{
	
	int rate;

	public NormalAccount(String accountNumber, String name, int balance, int rate) {
		super(accountNumber, name, balance);
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자:"+ rate +"%");
	}
}
