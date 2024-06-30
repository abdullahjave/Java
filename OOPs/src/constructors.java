
// using Constructors must be same name as Class and With no Return Type 

// 3 Types of Constructors 
// Default Constructor : Explicitly class when object of class is created 
// No Perameter Constructor 
// perametarized Constructor 

//============================================================================================

class infor
{
	private int id ;
	private String nameString ;
	private double Contact ;
	
	
	public infor()       // No perameter
	{
		System.out.println("This is No Perameter Constructor\n");
	}
	
	public infor(int id , String namString , double Contact )      // Perameter Constructor
	{
		System.out.println("These Value Set By Perametric Constructor");
		
		this.id = id ;
		this.nameString = namString;
		this.Contact = Contact ;
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public double getContact() {
		return Contact;
	}
	public void setContact(double contact) {
		Contact = contact;
	}
	
	public void Display()
	{
		System.out.println("Name : " + getNameString() + " ID : " + getId() + " Contact : " + getContact());
	}
	
}

public class constructors {

	public static void main(String[] args) 
	{
		
		infor information = new infor();  // Calling First Constructor 
		
		int id = 50 ;
		String nameString = "Abdullah";
		double Contact = 0312347334;
		
		infor information1 = new infor(id , nameString , Contact); // Calling Perametarized  Constructor 
		information1.Display();
		
 //Settig getter and Setters Values 		
		int id1 = 64 ;
		String nameString1 = "Ali";
		double Contact1 = 031234332 ;
		
//	
		information1.setId(id1);
		information1.setNameString(nameString1);
		information1.setContact(Contact1);
		
		System.out.println("\nThose values Set by Getters and Setters \nName : " + nameString1);
		System.out.println("Id : " + id1);
		System.out.println("Contact : " + Contact1);
		System.out.println(information1.getNameString());
		System.out.println();
			

	}

}
