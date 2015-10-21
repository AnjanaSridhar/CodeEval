package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FollowingInteger {

	static String out = "";
	static int total = 1;
	static int index = 0;
	static List<String> l1 = new ArrayList<String>();
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
			    	followingInteger(lineArray[i]);
			    	index = 0;
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

	private static void followingInteger(String string) {
		// TODO Auto-generated method stub
		System.out.println("--------------"+string);
		index = index+1;
		if(index==string.length()){
			return;
		}
		string = string.substring(index);
		followingInteger(string);
		l1.add(string);
		System.out.println(l1);
	}
	
	private static void list(String num) {
		
		int count =0;
		int len = num.length();
		String one = num.charAt(0)+"";
		num = num.substring(1);
		for(int i=0; i<num.length(); i++){
			
		}
		
	}
}
