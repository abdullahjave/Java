
import java.util.Scanner;

class bank 
{
	private int amount;
	private int id ;
	private String nameString;
	
	public bank(int amount , int id , String nameString)
	{
		this.amount = amount;
		this.id = id ;
		this.nameString = nameString;
	}

	public int getAmount() {
		return amount;
	}

//	public void setAmount(int amount) {
//		this.amount = amount;
//	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getNameString() {
		return nameString;
	}

//	public void setNameString(String nameString) {
//		this.nameString = nameString;
//	}
//	
	public void Showbal()
	{
		System.out.println("Name : " + getNameString() +  " ID is : " + id + "Balance is : " +  amount);
	}
}




public class Banking {

	public static void main(String[] args) 
	{	
		Scanner ss = new Scanner(System.in);
		int amount = ss.nextInt();
		int id = ss.nextInt();
		String nameString = ss.next();
		
	    bank b2 = new bank(amount , id , nameString );
	    b2.Showbal();
	    
		
		
	}

}
