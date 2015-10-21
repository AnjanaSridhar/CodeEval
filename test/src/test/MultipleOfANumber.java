package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultipleOfANumber {

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
			    	 int ret = smallestMultiple(lineArray[0]);
			    	 System.out.println(ret);
			    	
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

	private static int smallestMultiple(String line) {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(line.split(",")[0]);
		String num = line.split(",")[1];
		if(!(num.endsWith("0")||num.endsWith("2")||num.endsWith("4")||num.endsWith("6")||num.endsWith("8"))){
			return 0;
		}
		int n = Integer.parseInt(num);
		
		for(int i=2; i<x; i++){
			int val = n*i;
			if((val>x) || (x==val)){
				return n*i;
			}
			continue;
		}
		return 0;
	}
}
