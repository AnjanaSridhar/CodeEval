package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FirstNonRepeatedChar {

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
						firstNonRepChar(lineArray[i]);
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

	private static void firstNonRepChar(String string) {
		// TODO Auto-generated method stub
		String out = "";
		for(int i=0; i<string.length(); i++){
			String val = string.charAt(i)+"";
			if(i==string.length()-1){
				System.out.println(string.charAt(i));
				break;
			}
			out = string.substring(0,i)+string.substring(i+1);
			if(!out.contains(val)){
				System.out.println(val);
				break;
			}
		}
		
	}
}
