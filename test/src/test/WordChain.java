package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordChain {

	static int count = 0;
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
						wordChain(lineArray[i]);
						count = 0;
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

	private static void wordChain(String string) {
		// TODO Auto-generated method stub
		String[] strarr = string.split(",");
		
		for(int i=0; i<strarr.length; i++){
			String one = strarr[i];
			if(count==strarr.length){
				System.out.println(count);
				return;
			}
			for(int j=0; j<strarr.length; j++){
				
				if(strarr[j].charAt(0)==one.charAt(one.length()-1)){
					count = count+2;
				}
			}
		}
		if(count==0){
			System.out.println("None");
			return;
		}
		System.out.println(count);
	}
}
