package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayAbsurdity {

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
						arrayAbsurdity(lineArray[i]);
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

	private static void arrayAbsurdity(String string) {
		// TODO Auto-generated method stub
		//System.out.println("string is "+string);
		if(string.equals("")){
			System.out.println("");
			return;
		}
		string = string.substring(string.indexOf(";")+1);
		String[] arr = string.split(",");
		string = ","+string+",";
		for(int i=0; i<arr.length; i++){
			int len = arr[i].length();
			string = string.substring(string.indexOf(","+arr[i]+",")+(len+1));
			if(string.contains(","+arr[i]+",")){
				System.out.println(arr[i]);
				break;
			}
		}
	}
}
