package ver03;

import java.util.InputMismatchException;
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
			rate = scan.nextInt();
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
		try {
			System.out.println("***입금***");
			System.out.println("계좌번호와 입금할 금액을 입력하세요.");
			Scanner scan = new Scanner(System.in);
			System.out.print("계좌번호:");
			String SearchAccount = scan.next();
			System.out.print("입금액:");
			deposit = scan.nextInt();
			if(deposit<0) {
				System.out.println("입금할 금액을 다시 적어주세요.");
				return;
			}
			else if(deposit % 500!=0) {
				System.out.println("입금할 금액을 다시 적어주세요.");
				return;
			}
			for(int i=0; i<numOfAcc ; i++) {
			
				if(SearchAccount.compareTo(acc[i].getAccount())==0) {
					acc[i].setBalance((int)(acc[i].getBalance()
							+(acc[i].getBalance()*(acc[i].getRate()*0.01))+ deposit));
				}
			}
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
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
					System.out.print("잔고가 부족합니다. 금액전체를 출금할까요?(YES)출금취소할까요?(NO)");
					String answer = scan.next();
					if(answer.equals("YES")) {
						acc[i].setBalance(acc[i].getBalance()-acc[i].getBalance());
					}
					else if(answer.equals("NO")) {
						break;
					}
				}
				else if(withdraw%1000!=0) {
					System.out.println("출금은 1000원 단위로만 출금이 가능합니다.");
					return;
				}
				else if(withdraw<0) {
					System.out.println("출금할 금액을 다시 적어주세요.");
					return;
				}
				else {
					acc[i].setBalance(acc[i].getBalance()- withdraw);
				}
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

