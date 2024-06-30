package db_objs;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction 
{
	private final int userId;
	private final String transaction;
	private final BigDecimal transactionAmount;
	private final Date transactionDate ;
	
	public Transaction(int userId , String transaction , BigDecimal transactionAmount ,Date transactionDate)
	{
		this.userId = userId;
		this.transaction = transaction;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public int getUserId() {
		return userId;
	}

	public String getTransaction() {
		return transaction;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
	
	
	
}
