package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringSubstitution {

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
					stringSubstitution(lineArray[i]);
				}
				//System.out.println();
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void stringSubstitution(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0, string.indexOf(";"));
		String[] arr = string.substring(string.indexOf(";")+1).split(",");
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		int count = 9999;
		for(int i=0; i<arr.length; i=i+2){
			if(str1.contains(arr[i])){
				l1.add(count+"");
				str1 = str1.replaceAll(arr[i], count+"");
				l2.add(arr[i+1]);
			}
			count = count-1;
		}
		for(int i=0; i<l1.size(); i++){
			str1 = str1.replace(l1.get(i), l2.get(i));
		}
		System.out.println(str1);
	}
	
}
