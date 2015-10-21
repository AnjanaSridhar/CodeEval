package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringToDigit {

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
			    		stringToDigit(lineArray[i]);
			    		
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

	private static void stringToDigit(String string) {
		// TODO Auto-generated method stub
		String[] words = string.split(";");
		for(int i=0; i<words.length; i++){
			if(words[i].startsWith("z")){
				System.out.print(0);
				continue;
			}
			if(words[i].startsWith("e")){
				System.out.print(8);
				continue;
			}
			if(words[i].startsWith("n")){
				System.out.print(9);
				continue;
			}
			if(words[i].startsWith("th")){
				System.out.print(3);
				continue;
			}
			if(words[i].startsWith("tw")){
				System.out.print(2);
				continue;
			}
			if(words[i].startsWith("o")){
				System.out.print(1);
				continue;
			}
			if(words[i].startsWith("si")){
				System.out.print(6);
				continue;
			}
			if(words[i].startsWith("se")){
				System.out.print(7);
				continue;
			}
			if(words[i].startsWith("fo")){
				System.out.print(4);
				continue;
			}
			if(words[i].startsWith("fi")){
				System.out.print(5);
				continue;
			}
		}
	}
}
