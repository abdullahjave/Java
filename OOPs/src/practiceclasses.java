import java.util.Scanner;


class Employee
{
	private int salary;
	private String name;
	
	public void setsalary(int salary)
	{
		this.salary = salary;
	}
	public void setname(String name)
	{
		this.name = name ;
	}
	public int getsalary() {
		return salary ;
	}
	
	public String getname()
	{
		return name; 
	}
	
	public void Display() 
	{
		System.out.println("Name is : " + name + "Salary is : " + salary );

		System.out.println("Name is : " + getname() + "Salary is : " + getsalary() );
	}
	
}




public class practiceclasses {

	
	public static void main(String[] args) 
	{
			Employee khanEmployee = new Employee();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Salary ");
			int salary = scanner.nextInt();
			
			khanEmployee.setsalary(salary);
			System.out.println("Enter the Name ");
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();
			
			khanEmployee.setname(name);
			
			khanEmployee.Display();

	}

}
