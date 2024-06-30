
// Abstract Classes is the Class that is Declared (abstract) . it may or may not include abstract methods
// Abstract Methods that is Decleared Without an Implementations 
// If any class has Abstract method then it must be Abstract Class 
// Abstract Method must be Overrided
// Abstract class has no OBJECT 

//----------------------------------------------------------------------------------------------------------

abstract class parent    // must be Abstract
{
	
	abstract public void sum();
	abstract public void product();      // Abstract Method Without implementations 
	
	public parent()
	{
		System.out.println("This is a Parent class ");
	}
	
}

class child extends parent   // Extended Class must Implement all Method of Abstract class
{
	int a = 5 ;
	int b = 10 ;
	
	public void sum()    // Abstract method usnig using in another class 
	{
		System.out.println("Abstract Method Sum is : " + (a+b));
	}
	
	public void product()    // Abstract method usnig using in another class 
	{
		System.out.println("Abstract Method Product is : " + (a*b));
	}
}
public class Abstractclass
{
	
	public static void main(String[] args) 
	{
		child c = new child();
		c.sum();
		c.product();
	}

}
