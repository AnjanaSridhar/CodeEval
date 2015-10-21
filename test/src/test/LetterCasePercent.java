package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LetterCasePercent {

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
	    int num=0;
	   try {
			while ((line = in.readLine()) != null) {
			    String[] lineArray = line.split("\\n");
			    if (lineArray.length > 0) {
			        //Process line of input Here
			    	for(int i=0; i<lineArray.length; i++){
			    		letterCasePercent(lineArray[i]);
			    					    		
			    	}
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

	private static void letterCasePercent(String string) {
		// TODO Auto-generated method stub
		int low=0, up=0;
		float len = string.length();
		for (int i=0; i<len; i++) {
			if(Character.isLowerCase(string.charAt(i))){
				low = low+1;
			}
			else{
				up = up+1;
			}
		}
		float lowpercent = low/len*100;
		float uppercent = up/len*100;
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.print("lowercase: "+formatter.format(lowpercent)+" uppercase: "+formatter.format(uppercent));
	}
}
