
class Employees 
{
	int id ;
	String name;
	int Salary ;
	
	public void printDetails()
	{
		System.out.println("MY Id is : " + id );
		System.out.println("My name is : " + name);
	}
	
	public int getSalary()
	{
		return Salary ;
	}
}

public class Classes_Objects 
{

	public static void main(String[] args) 
	{
		Employees abdullah = new Employees(); // Instantiation of new Object 
		//Setting Attributes values
		abdullah.id = 15;
		abdullah.name = "This is Abdullah";
		abdullah.Salary = 24;
		
//		System.out.println(a.id);
//		System.out.println(a.name);
		
		Employees jawad = new Employees();
		
		jawad.id = 13;
		jawad.name = "This is Jawad";
		jawad.Salary = 19;
		

		
		abdullah.printDetails();
		jawad.printDetails();
		
		int Salary = jawad.getSalary();
		System.out.println(Salary);
		}
}