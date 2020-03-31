package ver05;

import java.sql.SQLException;

public class Insert extends IConnectImpl{
	
	String accountNumber;
	String name;
	int balance;
	
	public Insert(String accountNumber, String name, int balance) {
		super("kosmo","1234");
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public void execute() {
	
		try {
			String query = "INSERT INTO banking_tb VALUES(seq_banking.nextval, ?, ?, ?)";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, accountNumber);
			psmt.setString(2, name);
			psmt.setInt(3, balance);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
