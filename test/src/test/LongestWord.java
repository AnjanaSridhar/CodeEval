package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LongestWord {

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
			    //Process line of input Here
			    	for(int i=0; i<lineArray.length; i++){
			    		getLongestWord(lineArray[i]);
			    		
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

	private static void getLongestWord(String string) {
		// TODO Auto-generated method stub
		String[] arr = string.split(" ");
		string = null;
		String fin = "";
		int size = 0;
		for(int i=0; i<arr.length; i++){
			int len = arr[i].length();
			if(len>size){
				size = len;
				fin = arr[i];
			}
		}
		arr = null;
		System.out.println(fin);
	}
}
