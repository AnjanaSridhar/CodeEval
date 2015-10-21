package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UniqueElements {

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
						uniqueElem(lineArray[i]);
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

	private static void uniqueElem(String string) {
		// TODO Auto-generated method stub
		String[] arr = string.split(",");
		String temp = "";
		for(int i=0; i<arr.length; i++){
			//System.out.println(temp.indexOf(arr[i]));
			if(temp.indexOf(arr[i])==-1){
				temp = temp+arr[i]+",";
				//System.out.println(temp);
			}
		}
		arr=null;
		temp = temp.substring(0, temp.length()-1);
		System.out.println(temp);
	}
}