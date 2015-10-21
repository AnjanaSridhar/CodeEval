package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArmstrongNumber {

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
					for(int i=0; i<lineArray.length; i++){
						checkIfArmstrong(lineArray[i]);
					}
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
	private static void checkIfArmstrong(String string) {
		// TODO Auto-generated method stub
		int pow = string.length();
		double sum =0;
		for(int i=0; i<string.length(); i++){
			sum = sum+Math.pow(Integer.valueOf(string.charAt(i)+""), pow);
		}
		if(Integer.valueOf(string)==sum){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
	}
}
