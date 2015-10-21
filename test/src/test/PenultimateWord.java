package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PenultimateWord {

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
			    		String[] arr = lineArray[i].split(" ");
			    		System.out.print(arr[arr.length-2]);
			    		
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
}
