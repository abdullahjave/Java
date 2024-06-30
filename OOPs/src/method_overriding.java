// When Child class has the same method (Access specifier , Name , Return type , Datatypes etc )as the Parent class 
// when an object of subclass is created and the override method is called 


class class1
 {
	int a = 3;
	
	public void function()
	{
		System.out.println("This is Parent class Function" + a);
	}
	
	public void function2()
	{
		System.out.println("This is Parent class Function2" + (a+2));
	}
 }
 
class class2 extends class1
{
int a = 3;

	@Override   // this is not neccessary but recommended
	
	public void function()
	{
		System.out.println("This is Parent class Function" + a);
	}
	
	@Override
	public void function2()
	{
		System.out.println("This is Parent class Function2" + (a+2));
	}
}
public class method_overriding {

	public static void main(String[] args) 
	{
		class2 c2 = new class2();
		c2.function();     // it wont call Parent class method 
		
		class1 c1 = new class1();
		c1.function();    // it ill called Parent class

	}

}
