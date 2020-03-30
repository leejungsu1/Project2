import java.util.Scanner;

import ver02.Account;
import ver02.AccountManager;

public class BankingSystemVer2 {
	
	public static void main(String[] args) {
		AccountManager accM = new AccountManager();
		while(true) {
			accM.showMenu();
			Scanner scan = new Scanner(System.in);
			int exit = scan.nextInt();
			System.out.println("선택:"+ exit);
			
			if(exit==1) {
				accM.makeAccount();
			}
			else if(exit==2) {
				accM.depositMoney();
			}
				
			else if(exit==3) {
				accM.withdrawMoney();
			}
			else if(exit==4) {
				accM.showAllAccount();
			}
			else if(exit==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
