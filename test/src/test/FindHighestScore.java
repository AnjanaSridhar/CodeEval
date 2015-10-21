package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FindHighestScore {

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
						findHighestScore(lineArray[i]);
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

	private static void findHighestScore(String string) {
		// TODO Auto-generated method stub
		//System.out.println("--------------");
		int counter = string.length() - string.replace(" | ", " ").length();
		
		counter = counter/2+1;
		//System.out.println("counter>>"+counter);
		string = string.replace(" | ", " ");
		//System.out.println(string);
		String[] strarr = string.split(" ");
		int len = strarr.length/counter;
		int out = 0;
		int start = 0;
		int count=0;
		
		//System.out.println("-----"+strarr.length+" "+count+"  "+out+"  "+len);
		for(int i=0; i<strarr.length; i=i+len){
			//System.out.println("inp:"+strarr[i]+"  "+i);
			count = count+1;
			if(Integer.valueOf(strarr[i])>out){
				out = Integer.valueOf(strarr[i]);
				
			}
			//System.out.println("count>>"+count);
			if(count==counter && i!=strarr.length-1){
				System.out.print(out+" ");
				//System.out.println(">>>>>>>>>>>>in the if "+i);
				start = start+1;
				count=0;
				i=start-len;
				out=0;
			}
		}
		System.out.println(out);
	}
}
