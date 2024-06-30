import java.util.Scanner;

// Modify that where is the Variable / methods are Accessable 

// public (Accessable within the class and outside the class)
// Private (Accessable with in the Class only ( Using getter setters Methods ))
// Protected ()

class MyEmployee
{
	private int id ;
	private String name ;
	
	public void setname(String name)
	{
		this.name = name ;
	}
	public void setid(int id)
	{
		this.id = id ;
	}
	
	public String getname()
	{
		return name;
	}
	
	public int getid()
	{
		return id ;
	}
	
	public void Display()
	{
		System.out.println("The Id is : " + id);
		
		System.out.println("The Name is  : " + name);
	}
}

public class Accessmodifiers 
{
	public static void main(String[] args) 
	{
		MyEmployee employee = new MyEmployee();
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		employee.setid(id);
		
//		System.out.println("The Id is : " + employee.getid());
//		employee.id;
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		
		employee.setname(name);
		
		employee.Display();
//		System.out.println("The Name is  : " + employee.getname());
	}




	

}
