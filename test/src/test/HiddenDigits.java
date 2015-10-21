package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiddenDigits {

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
				if (lineArray.length > 0) {
					//Process line of input Here
					hiddenDigits(lineArray[0]);
					System.out.println();


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

	private static void hiddenDigits(String string) {
		// TODO Auto-generated method stub
		boolean res = false;
		for(int i=0; i<string.length(); i++){
			if("abc".contains(string.charAt(i)+"")){
				if(string.charAt(i)=='a'){
					System.out.print(0);
				}
				else if(string.charAt(i)=='b'){
					System.out.print(1);
				}
				else{
					System.out.print(2);
				}
				res = true;
			}
			else if("def".contains(string.charAt(i)+"")){
				if(string.charAt(i)=='d'){
					System.out.print(3);
				}
				else if(string.charAt(i)=='e'){
					System.out.print(4);
				}
				else{
					System.out.print(5);
				}
				res = true;
			}
			else if("ghij".contains(string.charAt(i)+"")){
				if(string.charAt(i)=='g'){
					System.out.print(6);
				}
				else if(string.charAt(i)=='h'){
					System.out.print(7);
				}
				else if(string.charAt(i)=='i'){
					System.out.print(8);
				}
				else{
					System.out.print(9);
				}
				res = true;
			}
			else if(Character.isDigit(string.charAt(i))){
				System.out.print(string.charAt(i));
				res = true;
			}
		}
		if(res==false){
			System.out.print("NONE");
		}
	}
}
