package ver02;

public class HighCreditAccount extends Account{
	int rate;
	String creditRateing;
	public HighCreditAccount(String accountNumber, String name, int balance, 
															int rate, String creditRateing) {
		super(accountNumber, name, balance);
		this.rate = rate;
		this.creditRateing = creditRateing;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getCreditRateing() {
		if(creditRateing == "A") {
			return 7;
		}
		else if(creditRateing == "B") {
			return 4;
		}
		else if(creditRateing == "C") {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자:"+ rate +"%");
		System.out.println("신용등급:"+ creditRateing);
	}
}
