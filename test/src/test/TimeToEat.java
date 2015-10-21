package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TimeToEat {

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
						sortTimes(lineArray[i]);
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

	private static void sortTimes(String string) {
		// TODO Auto-generated method stub
		string = string.replace(":", "");
		String[] strarr = string.split(" ");
		int[] intarr = new int[strarr.length];
		for(int i=0; i<strarr.length; i++){
			intarr[i] = Integer.valueOf(strarr[i]).intValue();
		}
		Arrays.sort(intarr);

		for(int i=intarr.length-1;i>-1; i--){
			if((intarr[i]+"").length()<6){
				int val = 6-(intarr[i]+"").length();
				String add = "";
				for(int j=0; j<val; j++){
					add = add+"0";
				}
				strarr[i] = add+intarr[i];
				System.out.print((strarr[i]+"").substring(0,2)+":"+(strarr[i]+"").substring(2,4)+":"+(strarr[i]+"").substring(4)+" ");

			}
			else{
				strarr[i] = intarr[i]+"";
				System.out.print((strarr[i]+"").substring(0,2)+":"+(strarr[i]+"").substring(2,4)+":"+(strarr[i]+"").substring(4)+" ");
			}
		}

		/*for(int i=strarr.length-1; i>-1; i--){
			System.out.print((strarr[i]+"").substring(0,2)+":"+(strarr[i]+"").substring(2,4)+":"+(strarr[i]+"").substring(4)+" ");

		}*/
	}
}
