import java.util.Scanner;

import ver05.Account;
import ver05.Insert;
import ver05.Select;
import ver05.Update_deposit;
import ver05.Update_withdraw;

public class BankingSystemVer5 {
	static String accountNumber;
	static String name;
	static int balance;
	
	public static void showMenu() {
		System.out.println("-------Menu-------");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}	
	public static void makeAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");
		accountNumber = scan.next();
		System.out.print("이름:");
		name = scan.next();
		System.out.print("잔고:");
		balance = scan.nextInt();
		new Insert(accountNumber, name, balance).execute();
		
		System.out.println("계좌개설이 완료되었습니다.");
	}
	public static void depositMoney() {
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");
		String SearchAccount = scan.next();
		System.out.print("입금액:");
		int deposit = scan.nextInt();
		
		new Update_deposit(SearchAccount, deposit).execute();
		System.out.println("입금이 완료되었습니다.");
	}
	public static void withdrawMoney() {
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");
		String SearchAccount = scan.next();
		System.out.print("출금액:");
		int withdraw = scan.nextInt();
		new Update_withdraw(SearchAccount, withdraw).execute();
			
		System.out.println("출금이 완료되었습니다.");
	}
	public static void showAccInfo() {
		new Select(accountNumber, name, balance).execute();
	}
	public static void main(String[] args) {
		
		while(true) {
			showMenu();
			Scanner scan = new Scanner(System.in);
			int exit = scan.nextInt();
			System.out.println("선택:"+ exit);
			
			if(exit==1) {
				makeAccount();
			}
			else if(exit==2) {
				depositMoney();
			}
				
			else if(exit==3) {
				withdrawMoney();
			}
			else if(exit==4) {
				showAccInfo();
			}
			else if(exit==5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
