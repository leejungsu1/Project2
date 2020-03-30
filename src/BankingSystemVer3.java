import java.util.InputMismatchException;
import java.util.Scanner;

import ver03.AccountManager;
import ver03.MenuSelectException;

public class BankingSystemVer3 {
	
	public static void main(String[] args) {
		AccountManager accM = new AccountManager();
		
		while(true) {
			try {
				accM.showMenu();
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if(!(choice==1 || choice==2 || choice==3 || choice==4 || choice==5)) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
				System.out.println("선택:"+ choice);
				if(choice==1) {
					accM.makeAccount();
				}
				else if(choice==2) {
					accM.depositMoney();
				}
				else if(choice==3) {
					accM.withdrawMoney();
				}
				else if(choice==4) {
					accM.showAllAccount();
				}
				else if(choice==5) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
			catch(MenuSelectException e) {
				e.printStackTrace();
			}
			catch(InputMismatchException e) {
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}
