
import java.util.Scanner;

public class Input {

	public static void main(String[] args)
	{
		
		// Object of Scanner Class 
		
		Scanner scanner = new Scanner(System.in);
		
		// Scanner Varible for input 
		
		System.out.println("Enter Your Name : ");
		String s = scanner.next();
		
		System.out.println("Your Name is : " + s +"\nEnter your Age : " );
		
		int n = scanner.nextInt();
		
		System.out.println("You age is : " + n );
		

	}

}
