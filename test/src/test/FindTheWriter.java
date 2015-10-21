package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindTheWriter {

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
			    for(int i=0; i<lineArray.length; i++) {
			        //Process line of input Here
			    	if(lineArray[i].equals("")){
			    		continue;
			    	}
			    	findTheWriter(lineArray[i]);
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

	private static void findTheWriter(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0, string.indexOf("|"));
		String str2 = string.substring(string.indexOf("|")+2);
		string=null;
		String[] arr = str2.split(" ");
		String fin = "";
		for(int i=0; i<arr.length; i++){
			fin = fin+str1.charAt(Integer.valueOf(arr[i]).intValue()-1);
		}
		System.out.println(fin);
	}
}
