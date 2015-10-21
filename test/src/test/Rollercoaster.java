package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rollercoaster {

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
			    		rollerCoaster(lineArray[i]);
			    					    		
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

	private static void rollerCoaster(String string) {
		// TODO Auto-generated method stub
		String fin="";
		boolean up = false;
		for(int i=0; i<string.length(); i++){
			if(!Character.isLetter(string.charAt(i))){
				fin=fin+string.charAt(i);
				continue;
			}
			if(up==false){
				fin=fin+Character.toUpperCase(string.charAt(i));
				up=true;
			}
			else{
				fin=fin+Character.toLowerCase(string.charAt(i));
				up=false;
			}
		}
		System.out.print(fin);
	}
}
