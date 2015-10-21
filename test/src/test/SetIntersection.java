package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetIntersection {

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
						setIntersection(lineArray[i]);
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

	private static void setIntersection(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0, string.indexOf(";"));
		String str2 = string.substring(string.indexOf(";")+1);
		List<String> l1 = new ArrayList<String>(str1.length());
		List<String> l2 = new ArrayList<String>();
		String[] strarr = str1.split(",");
		for(int i=0; i<strarr.length; i++){
			l1.add(strarr[i]);
		}
		strarr = null;
		strarr = str2.split(",");
		for(int i=0; i<strarr.length; i++){
			if(l1.contains(strarr[i])){
				l2.add(strarr[i]);
			}
		}
		l1=null;
		strarr=null;
		String out = l2+"";
		l2 = null;
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(", ", ",");
		System.out.println(out);
	}
}
