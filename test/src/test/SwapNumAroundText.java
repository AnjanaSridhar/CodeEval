package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SwapNumAroundText {

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
						swapNum(lineArray[i]);
						System.out.println();
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

	private static void swapNum(String string) {
		// TODO Auto-generated method stub
		String[] strarr = string.split(" ");
		for(int i =0 ; i<strarr.length; i++){
			int end = strarr[i].length()-1;
			strarr[i] = strarr[i].charAt(end)+strarr[i].substring(1,end)+strarr[i].charAt(0);
			System.out.print(strarr[i]+" ");
		}
	}
	
	
}
