import java.math.BigInteger;
import java.util.Scanner;

class Base1
{
	 private int ID   ;
	 private String nameString ;
	 
	 
//	 public Base1(int ID , String nameString) 
//	 {
//		this.ID = ID ;
//		this.nameString = nameString;
//	 }


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNameString() {
		return nameString;
	}


	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	
}

class Derived1 extends Base1
{
	private BigInteger Contact;
	private String gmail;
	
//	public Derived1(BigInteger Contact , String gmail)
//	{
//		
//		this.Contact = Contact ;
//		this.gmail = gmail ;
//	}

	public BigInteger getContact() {
		return Contact;
	}

	public void setContact(BigInteger contact) {
		Contact = contact;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
}

public class Inheritancess 
{

	public static void main(String[] args) 
	{
	 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int id = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter name : ");
		String nameString = scanner.next();
		
	// Base Class Objects : can only acces there own Data 
		Base1 base = new Base1();
		
		base.setID(id);
		base.setNameString(nameString);
		
		System.out.println("ID :" + base.getID());
		System.out.println("Name :" + base.getNameString());
		System.out.println("-------------------------------------------------------------------------");
		
//-----------------------------------------------------------------------------------------

		Scanner s = new Scanner(System.in);
		System.out.println("Enter Contact : ");
	    BigInteger Contact = s.nextBigInteger();
	    Scanner s1 = new Scanner(System.in);
	    System.out.println("Enter Gmail : ");
	    String gmail = s1.nextLine();
		
	// derived class object
		Derived1 derived = new Derived1(); 
		derived.setContact(Contact);
		derived.setGmail(gmail);
		
	// We Can also call Base Class Method and Data from Derieved Class
	
		derived.setID(id);
		derived.setNameString(nameString);
		
		System.out.println("ID :" + derived.getID());
		System.out.println("Name :" + derived.getNameString());
		System.out.println("Contact No :" + derived.getContact());
		System.out.println("Gmail :" + derived.getGmail());
		
	}

}

