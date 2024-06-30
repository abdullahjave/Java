import java.math.BigInteger;
import java.util.Scanner;

// In Perametric Constructor The Super Keyword construtor Must Contained All the Derieved Class Constructor Data 
// And Also The Super Class Data

class Pbase
{
	 private int ID   ;
	 private String nameString ;
	 
	 
	 public Pbase(int ID , String nameString) 
	 {
		this.ID = ID ;
		this.nameString = nameString;
	 }


	public int getID() {
		return ID;
	}

	public String getNameString() {
		return nameString;
	}

	
}

class Pderived1 extends Pbase
{
	private BigInteger Contact;
	private String gmail;
	
//	
	public Pderived1( int ID , String nameString , BigInteger Contact , String gmail)
	{
		
		//Here we need Supper to Call the Perametric Constructor of Super Class
		super(ID, nameString );
		
		this.Contact = Contact ;
		this.gmail = gmail ;
	}

	public BigInteger getContact() {
		return Contact;
	}


	public String getGmail() {
		return gmail;
	}
	
}
public class PeraConstruct {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int id = scanner.nextInt();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter name : ");
		String nameString = scanner.next();
		
	// Base Class Objects : can only acces there own Data 
		Pbase base = new Pbase(id , nameString);
		
		
//		base.setID(id);
//		base.setNameString(nameString);
		
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
	  
	    Pderived1 derived = new Pderived1(id , nameString , Contact , gmail); 
//		derived.setContact(Contact);
//		derived.setGmail(gmail);
//		
	// We Can also call Base Class Method and Data from Derieved Class
	
//		derived.setID(id);
//		derived.setNameString(nameString);
		
		System.out.println("ID :" + derived.getID());
		System.out.println("Name :" + derived.getNameString());
		System.out.println("Contact No :" + derived.getContact());
		System.out.println("Gmail :" + derived.getGmail());

	}

}
