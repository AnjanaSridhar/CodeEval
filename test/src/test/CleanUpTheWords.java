package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CleanUpTheWords {

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
						cleanUpTheWords(lineArray[i]);
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

	private static void cleanUpTheWords(String string) {
		// TODO Auto-generated method stub
		String end = "";
		for(int i=0; i<string.length(); i++){
			if(Character.isAlphabetic(string.charAt(i))){
				end = end+string.charAt(i);
			}
			else{
				end = end+" ";
			}
		}
		end = end.replaceAll("\\s+", " ");
		end = end.trim();
		end = end.toLowerCase();
		System.out.println(end);
	}
}