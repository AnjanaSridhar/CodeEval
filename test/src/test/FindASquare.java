package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindASquare {

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
						isSquare(lineArray[i]);
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

	private static void isSquare(String string) {
		// TODO Auto-generated method stub
		//System.out.println(string);
		string = string.replace(" (", "");
		string = string.replace("(", "");
		string = string.replace(")", "");
		//System.out.println(string);
		String[] strarr = string.split(",");
		List<Integer> l1 = new ArrayList<Integer>();
		//System.out.println(strarr.length);
		for(int i=0; i<strarr.length; i++){
			//System.out.println(strarr[i]);
			l1.add(Integer.valueOf(strarr[i]));
		}
		/*for(int i=1; i<strarr.length; i=i+2){
			l1.add(Integer.valueOf(strarr[i]));
		}*/
		//System.out.println(l1);
		int count = 0;
		for(int i=0; i<l1.size(); i++){
			int val = l1.get(i);
			l1.set(i, 99999);
			if(l1.contains(val)==false){
				if(count>4){
					break;
				}
				else{
					System.out.println("false");
					return;
				}
			}
			else{
				count = count+1;
			}
			//System.out.println(l1);
			l1.set(l1.indexOf(val), 99999);
			
			
		}
		System.out.println("true");
	}
}
