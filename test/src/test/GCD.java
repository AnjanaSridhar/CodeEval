package test;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args){
		//File file = new File(args[0]);
		
		Scanner inp = new Scanner(System.in);
		try {
			System.out.print("Enter your first number: ");
			int num1 = inp.nextInt();
			System.out.print("Enter your second number: ");
			int num2 = inp.nextInt();
			int result = getGCD(num1, num2);
			System.out.println("GCD is : "+result);
		
			inp.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int getGCD(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num2==0 || num1 ==0){
			return num1+num2;
		}
		if(num1>num2){
			return getGCD(num2, num1%num2);
		}
		else{
			return getGCD(num1, num2%num1);
		}
	}

}

