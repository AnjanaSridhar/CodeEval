package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SplitTheNumber {

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
					splitTheNumber(lineArray[0]);
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

	private static void splitTheNumber(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0, string.indexOf(" "));
		String str2 = string.substring(string.indexOf(" "));
		//System.out.println(str1+"  "+str2);
		int val = 0;
		if(str2.contains("+")){
			//System.out.println(">>>>>>>>>>"+str1.substring(0, str2.indexOf("+"))+"  "+str1.substring(str2.indexOf("+")+1));
			val = Integer.valueOf(str1.substring(0, str2.indexOf("+")-1))+
					Integer.valueOf(str1.substring(str2.indexOf("+")-1));
		}
		else{
			//System.out.println(">>>>>>>>>>"+"  "+str1.substring(0, str2.indexOf("-")-1)+"  "+str1.substring(str2.indexOf("-")-1));
			val = Integer.valueOf(str1.substring(0, str2.indexOf("-")-1))-
					Integer.valueOf(str1.substring(str2.indexOf("-")-1));
		}
		System.out.println(val);
	}

}
