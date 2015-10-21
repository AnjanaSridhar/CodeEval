package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MixedContect {

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
						mixedContent(lineArray[i]);
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

	private static void mixedContent(String string) {
		// TODO Auto-generated method stub
		if(string.length()==0){
			System.out.print("");
			return;
		}
		String[] arr = string.split(",");
		string=null;
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		for(int i=0; i<arr.length; i++){
			if(Character.isDigit(arr[i].charAt(0))){
				l1.add(arr[i]);
			}
			else{
				l2.add(arr[i]);
			}
		}
		arr=null;
		String out="";
		if(l2.size()!=0){
			out = l2+"";
		}
		if(l1.size()!=0 && l2.size()!=0){
			out = out+"|";
		}
		out = out+l1;
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(", ", ",");
		System.out.print(out);
	}
}
