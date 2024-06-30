package db_objs;

import java.math.BigDecimal;
import java.math.RoundingMode;

//user entity in database to store information of user

public class User 
{
	private final int id;
	private final String username ;
	private final String password;
	private BigDecimal currentBalance;
	
	public User(int id , String username, String password,  BigDecimal currentBalance)
	{
		this.id = id ;
		this.username = username;
		this.currentBalance = currentBalance;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(BigDecimal newBalance)
	{
		currentBalance = newBalance.setScale(2,RoundingMode.FLOOR);
	}
	
	
}
