package ver05;

import java.sql.SQLException;

public class Update_withdraw extends IConnectImpl{
	
	String accountNumber;
	int withdraw;
	
	public Update_withdraw(String accountNumber, int withdraw) {
		super("kosmo","1234");
		this.accountNumber = accountNumber;
		this.withdraw = withdraw;
	}

	@Override
	public void execute() {
		
		try {
			String query = "UPDATE banking_tb SET balance=(balance-?) WHERE account = ?";
			psmt = con.prepareStatement(query);
			
			psmt.setInt(1, withdraw);
			psmt.setString(2, accountNumber);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 업데이트 되었습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
