package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SortMatrixColumns {

	private static int[] intarr1 = null;
	private static int[] intarr2 = null;
	private static int[] intarr3 = null;
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
						sortMatCol(lineArray[i]);
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

	private static void sortMatCol(String string) {
		// TODO Auto-generated method stub
		String[] strarr = string.split(" | ");
		intarr1 = new int[strarr.length];
		intarr2 = new int[strarr.length];
		intarr3 = new int[strarr.length];
		int ind = 0;
		for(int i=0; i<strarr[0].split(" ").length; i++){
			intarr1[i] = Integer.valueOf(strarr[ind].split(" ")[i]);
			intarr2[i] = Integer.valueOf(strarr[ind].split(" ")[i]);
			intarr1[i] = Integer.valueOf(strarr[ind].split(" ")[i]);
		}
		
	}
}
