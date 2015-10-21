package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ColumnNames {

	private static String[] alpha1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	private static String[] alpha2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	private static String[] alpha3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};





	public static void main(String[] args) {

		int count = 0;
		List<String> list3 =  new ArrayList<String>();
		for (int k = 0; k < alpha1.length; k++) {
			//System.out.print(alpha1[i]+alpha2[j]+alpha3[k]);
			//System.out.print(",");
			list3.add(alpha1[k]);
			count = count+1;
		}
		//System.out.println();
		//System.out.println(count);
		for (int j = 0; j < alpha2.length; j++) {
			for (int k = 0; k < alpha3.length; k++) {
				//System.out.print(alpha2[j]+alpha3[k]);
				//System.out.print(",");
				list3.add(alpha2[j]+alpha3[k]);
				count = count+1;
			}
		}
		for (int i = 0; i < alpha1.length; i++) {
			for (int j = 0; j < alpha2.length; j++) {
				for (int k = 0; k < alpha3.length; k++) {
					//System.out.print(alpha1[i]+alpha2[j]+alpha3[k]);
					//System.out.print(",");
					list3.add(alpha1[i]+alpha2[j]+alpha3[k]);
					count = count+1;
				}
			}
		}
		
		//System.out.println();
		//System.out.println(list3);
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
								
								int val = Integer.valueOf(lineArray[i]);
								System.out.println(list3.get(val-1));
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



}
