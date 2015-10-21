package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class Sorting {

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
			    		sort(lineArray[i]);
			    		
			    	}
			    	System.out.println();
			    }
				
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void sort(String string) {
		// TODO Auto-generated method stub
		String[] arr = string.split(" ");
		string=null;
		float[] intarr = new float[arr.length];
		
		for(int i=0; i<arr.length; i++){
			intarr[i] = Float.valueOf(arr[i]).floatValue();
		}
		arr=null;
		Arrays.sort(intarr);
		NumberFormat formatter = new DecimalFormat("#0.000");
		 
		for(int j= 0; j<intarr.length; j++){
			String str=formatter.format(intarr[j]);
			System.out.print(str +" ");
		}
	}
}
