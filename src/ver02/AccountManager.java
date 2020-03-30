package ver02;

import java.util.Scanner;

public class AccountManager {
	String accountNumber;
	String name;
	int balance;
	int rate; 
	int deposit;
	int numOfAcc=0;
	Account[] acc = new Account[50];
		
	public  void showMenu() {
		System.out.println("-------Menu-------");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}	
	public  void makeAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("----계좌선택----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		int choice = scan.nextInt();
		System.out.print("선택:"+ choice);
		System.out.println();
		if(choice==1) {
			System.out.print("계좌번호:");
			accountNumber = scan.next();
			System.out.print("고객이름:");
			name = scan.next();
			System.out.print("잔고:");
			balance = scan.nextInt();
			System.out.print("기본이자%(정수형태로입력):");
			int rate = scan.nextInt();
			acc[numOfAcc++] = new NormalAccount(accountNumber, name, balance, rate);
			System.out.println("계좌개설이 완료되었습니다.");
		}
		else if(choice==2) {
			System.out.print("계좌번호:");
			accountNumber = scan.next();
			System.out.print("고객이름:");
			name = scan.next();
			System.out.print("잔고:");
			balance = scan.nextInt();
			System.out.print("기본이자:");
			rate = scan.nextInt();
			System.out.print("신용등급(A,B,C등급):");
			String creditRateing = scan.next();
			acc[numOfAcc++] = new HighCreditAccount(accountNumber, name, balance, rate, creditRateing);
			System.out.println("계좌개설이 완료되었습니다.");
		}
	}
	public  void depositMoney() {
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");
		String SearchAccount = scan.next();
		System.out.print("입금액:");
		deposit = scan.nextInt();
		
		for(int i=0; i<numOfAcc ; i++) {
			
			if(SearchAccount.compareTo(acc[i].getAccount())==0) {
				acc[i].setBalance((int)(acc[i].getBalance()
						+(acc[i].getBalance()*(acc[i].getRate()*0.01))+ deposit));
			}
		}
		System.out.println("입금이 완료되었습니다.");
	}
	public  void withdrawMoney() {
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호:");
		String SearchAccount = scan.next();
		System.out.print("출금액:");
		int withdraw = scan.nextInt();
			
		for(int i=0; i<numOfAcc ; i++) {
			
			if(SearchAccount.compareTo(acc[i].getAccount())==0) {
				if(acc[i].getBalance()< withdraw) {
					System.out.println("잔액이 부족합니다.");
					return;
				}
				acc[i].setBalance(acc[i].getBalance()- withdraw);
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}
	public void showAllAccount() {
		for(int i=0 ; i<numOfAcc ; i++) {
			acc[i].showAccInfo();
			System.out.println("-------------");
			System.out.println("전체계좌정보가 출력이 완료되었습니다.");
		}
	}
}

