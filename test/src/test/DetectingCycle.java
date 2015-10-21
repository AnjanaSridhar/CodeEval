package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetectingCycle {

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
						detectCycle(lineArray[i]);
						count=0;
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

	private static void detectCycle(String string) {
		// TODO Auto-generated method stub
		String[] str = string.split(" ");
		List<String> l1 = new ArrayList<String>(str.length);
		List<String> l2 = new ArrayList<String>(str.length);
		for(int i=0; i<str.length; i++){
			l1.add(str[i]);
		}
		str = null;
		for(int j=1; j<l1.size(); j++){
			if(l1.indexOf(l1.get(j)) < j){
				if(l2.indexOf(l1.get(j))==-1){
					l2.add(l1.get(j));
					count = count+1;
				}
				else{
					break;
				}
			}
			else{
				if(count>0){
					break;
				}


			}
		}
		String out = l2+"";
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(",", "");
		System.out.println(out);
	}
}
