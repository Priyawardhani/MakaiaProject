package tests;

import java.util.Scanner;

public class NewMethod {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the password:" + "");
		String Password=obj.nextLine();
		int length = Password.length();
		System.out.println("length of the string" + " "+length);
		if(length>=10)
		{
			if((Password.matches(".*[a-z].*"))&&(Password.matches(".*[A-Z].*"))&&(Password.matches(".*[0-9].*")))
			{
				System.out.println("Password is valid");
			}
			else
			{
				System.out.println("Password is invalid - must have letters and numbers");
			}
		}	

		else
		{
			System.out.println("Password is invalid - must be 10 characters");
		}
		
	
	}

}
