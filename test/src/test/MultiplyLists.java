package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiplyLists {

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
			    		multiplyLists(lineArray[i]);
			    		
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

	private static void multiplyLists(String string) {
		// TODO Auto-generated method stub
		//System.out.println(string);
		String str1 = string.substring(0, string.indexOf("|")-1);
		String str2 = string.substring(string.indexOf("|")+2);
		String out = "";
		string=null;
		//System.out.println(str1+"::"+str2);
		int count=0;
		int len = str1.length();
		//System.out.println(str1.substring(0, str1.indexOf(" ")) + ":"+str2.substring(0, str2.indexOf(" ")));
		while(count<len && str1.contains(" ")){
			int num = Integer.valueOf(str1.substring(0, str1.indexOf(" ")))*Integer.valueOf(str2.substring(0, str2.indexOf(" ")));
			//System.out.println(num);
			str1 = str1.substring(str1.indexOf(" ")+1);
			str2 = str2.substring(str2.indexOf(" ")+1);
			out = out+num+" ";
			count=count+1;
			
		}
		
		int num = Integer.valueOf(str1)*Integer.valueOf(str2);
		out = out+num+" ";
		if(out.endsWith(" ")){
			out = out.substring(0, out.length()-1);
		}
		System.out.println(out);
	}
}
