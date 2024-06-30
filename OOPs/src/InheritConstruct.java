// When we execute Derived Class then First it will Execute the Base Class Constructor 
// Because there is By Default Super KeyWord

class Baseclass
{

	 public Baseclass() 
	 {
		 System.out.println("I'm Base in Class");
	 }
	
}

class Derivedclass extends Baseclass
{
	
	public Derivedclass()   // There is By Default Super Method : Which Access One Class Constructor from another
	{
	//	super();         // it must be First Statment 
		System.out.println("I'm Derived Class Constructor ");
	}

}

public class InheritConstruct {

	public static void main(String[] args) 
	{
		Derivedclass derived = new Derivedclass(); 	// we are calling Derived Class 		

	}

}
