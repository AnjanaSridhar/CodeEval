package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MorseCode {

	static String[] strarr = new String[]{".----",  "..---",  "...--",  "....-","....." , "-...." , "--..." , "---..",  "----.",  "-----",
		".-",  "-..."  ,"-.-."  ,"-.."  ,"."  ,"..-."  ,"--."  ,"...."  ,".."  ,".---"  ,"-.-"  ,".-.."  ,"--"  ,"-."  ,"---" ,".--."  ,
		"--.-"  ,".-."  ,"..."  ,"-"  ,"..-"  ,"...-"  ,".--"  ,"-..-"  ,"-.--"  ,"--.."};
	
	static String[] strarr2 = new String[]{"1"  ,"2"  ,"3"  ,"4"  ,"5"  ,"6"  ,"7"  ,"8"  ,"9"  ,"0"  ,"A" ,"B" ,"C",
		"D" ,"E" ,"F" ,"G" ,"H" ,"I" ,"J" ,"K" ,"L" ,"M" ,"N" ,"O" ,"P" ,"Q" ,"R" ,"S" ,"T" ,"U" ,"V" ,"W" ,"X" ,"Y" ,"Z"}; 
	
	
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
						morseCode(lineArray[i]);
						System.out.println();
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

	private static void morseCode(String string) {
		// TODO Auto-generated method stub
		
		String[] strarr1 = string.split(" ");
		
		List<String> l1 = new ArrayList<String>();
		
		for(int i=0; i<strarr.length; i++){
			l1.add(strarr[i]);
		}
		for(int i=0; i<strarr1.length; i++){
			if(l1.indexOf(strarr1[i])==-1){
				System.out.print(" ");
			}
			else{
				System.out.print(strarr2[l1.indexOf(strarr1[i])]);
			}
		}
	}
}
