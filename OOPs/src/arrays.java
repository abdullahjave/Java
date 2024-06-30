
public class arrays {

	public static void main(String[] args) 
	{
		// Without loop 
		int marks[] = {98,76,87,78,96};
		
		System.out.println(marks[0]);
		System.out.println(marks[1]);
		System.out.println(marks[2]);
		System.out.println(marks[3]);
		System.out.println(marks[4]);
		
		// With loop 
		System.out.println("---------------------------------------------------------------");

		for (int i = 0; i < marks.length; i++)
		{
			System.out.println("Student "+ (i+1) + " marks is : " + marks[i] );
		}
		
		//in Reverse order 
		System.out.println("---------------------------------------------------------------");
		
		for (int i = marks.length - 1; i >=0; i--) 
		{
			System.out.println("Student "+ i+1 + " marks is : " + marks[i] );
		}
		
		// For Each Loop 
		
		System.out.println("---------------------------------------------------------------");

		for(int i : marks)
		{
			System.out.println(i);
		}
	}

}
