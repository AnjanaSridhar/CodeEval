package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fibonacci {

	public static void main (String[] args) {
	    //File file = new File(args[0]);
	    File file = new File("C:/Local/input1.txt");
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String line;
	   try {
			while ((line = in.readLine()) != null) {
			    String[] lineArray = line.split("\\n");
			    for(int i=0; i<lineArray.length; i++){
			    		nthFibonacci(lineArray[i]);
			    	}
			    
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void nthFibonacci(String line) {
		// TODO Auto-generated method stub
		int n = Integer.valueOf(line).intValue();
		if(n==1 || n==2){
			System.out.println(1);
			return;
		}
		else if(n==0){
			System.out.println(0);
			return;
		}
		int fib1 = 1, fib2 = 1, fin=0;
		for(int i=0; i<n-2; i++){
			fin = fib1 + fib2;
			fib1 = fib2;
			fib2 = fin;
		}
		System.out.println(fin);
	}
}
