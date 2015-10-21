package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfOnes {

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
						getNumberOfOnes(lineArray[i]);
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

	private static void getNumberOfOnes(String string) {
		// TODO Auto-generated method stub
		String val = Integer.toBinaryString(Integer.valueOf(string).intValue()).toString();
		int count = 0;
		for(int i=0; i<val.length(); i++){
			if(val.charAt(i)=='1'){
				count = count+1;
			}
		}
		System.out.println(count);
	}
}
