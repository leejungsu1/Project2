package ver04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ver04.Account;
import ver04.HighCreditAccount;
import ver04.NormalAccount;

public class AccountManager {
	String accountNumber;
	String name;
	int balance;
	int rate; 
	int deposit;
	int numOfAcc=0;
	HashSet<Account> acc = new HashSet<Account>();
		
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
			
			Iterator<Account> itr = acc.iterator();
			
			while(itr.hasNext()) {
				Account a = new NormalAccount(accountNumber, name, balance, rate);
				Account i = itr.next();
				if(i.equals(a)==true) {
					System.out.println("동일한 계좌번호가 존재합니다. 갱신할까요?(0)");
					int select = scan.nextInt();
					if(select==0) {
						acc.remove(i);
						acc.add(a);
					}
					else {
						choice=0;
					}
				}
			}
			acc.add(new NormalAccount(accountNumber, name, balance, rate));
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
			Iterator<Account> itr = acc.iterator();
			
			while(itr.hasNext()) {
				Account a = new HighCreditAccount(accountNumber, name, balance, rate, creditRateing);
				Account i = itr.next();
				if(i.equals(a)==true) {
					System.out.println("동일한 계좌번호가 존재합니다. 갱신할까요?(0)");
					int select = scan.nextInt();
					if(select==0) {
						acc.remove(i);
						acc.add(a);
					}
					else {
						choice=0;
					}
				}
			}
			acc.add(new HighCreditAccount(accountNumber, name, balance, rate, creditRateing));
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
			boolean answer = false;
			Iterator<Account> itr = acc.iterator();
			
			while(itr.hasNext()) {
				Account i = itr.next();
				if(SearchAccount.equals(i.getAccount())==true) {
					answer = true;
					i.setBalance(i.getBalance()+deposit);
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
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
		boolean answer = false;
		Iterator<Account> itr = acc.iterator();
		while(itr.hasNext()) {
			Account i = itr.next();
			if(SearchAccount.equals(i.getAccount())==true) {
				if(i.getBalance()<withdraw) {
					System.out.println(i.getBalance());
					System.out.print("잔고가 부족합니다. 금액전체를 출금할까요?(YES)출금취소할까요?(NO)");
					String user = scan.next();
					if(user.equalsIgnoreCase("YES")) {
						i.setBalance(i.getBalance()-i.getBalance());
					}
					else if(user.equalsIgnoreCase("NO")) {
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
					i.setBalance(i.getBalance()- withdraw);
				}
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}
	public void showAllAccount() {
		for(Account a : acc){
			a.showAccInfo();;
		}
			System.out.println("-------------");
			System.out.println("전체계좌정보가 출력이 완료되었습니다.");
	}
	public void saveAccount() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("src/ver04/AccountBook.obj"));
			
			out.writeObject(acc);
			out.writeObject(null);
			out.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void readAccount() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream("src/ver04/AccountBook.obj"));
			while(true) {
				HashSet<Account> a = (HashSet<Account>)in.readObject();
				if(a==null) break;
				acc = a;
			}
			System.out.println("저장된 파일을 찾았습니다.");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

