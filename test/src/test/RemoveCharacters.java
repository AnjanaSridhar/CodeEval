package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RemoveCharacters {

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
						removeChars(lineArray[i]);
						
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

	private static void removeChars(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0, string.indexOf(","));
		String str2 = string.substring(string.indexOf(",")+2);
		for(int i=0; i<str2.length(); i++){
			if(str1.contains(str2.charAt(i)+"")){
				str1 = str1.replaceAll(str2.charAt(i)+"", "");
				
			}
		}
		System.out.println(str1);
	}
}
