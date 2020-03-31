package ver05;

import java.sql.SQLException;

public class Select extends IConnectImpl{
	String accountNumber;
	String name;
	int balance;
	
	public Select(String accountNumber, String name, int balance) {
		super("kosmo","1234");
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String sql = "SELECT account, name, balance FROM banking_tb";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String acccount = rs.getString("account");
				String name = rs.getString("name");
				int balance = rs.getInt("balance");
				
				System.out.println("***전체계좌조회***");
				System.out.println("계좌번호:"+ acccount);
				System.out.println("이름:"+ name);
				System.out.println("잔고:"+ balance);
				System.out.println("===============");
			}
		}
		catch (SQLException e) {
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
