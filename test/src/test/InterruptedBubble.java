package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InterruptedBubble {

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
					partialBubble(lineArray[0]);
					System.out.println();
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

	private static void partialBubble(String string) {
		// TODO Auto-generated method stub
		String str1 = string.substring(0,string.indexOf(" | "));
		String str2 = string.substring(string.indexOf(" | ")+3, string.length());
		String[] arr = str1.split(" ");
		int[] arr2 = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			arr2[i] = Integer.valueOf(arr[i]).intValue();
		}
		int count = 0;
		while(count<Integer.valueOf(str2).intValue()){
			for(int i=0; i<arr2.length-1; i++){
				if(arr2[i]>arr2[i+1]){
					
					int temp = arr2[i];
					arr2[i] = arr2[i+1];
					arr2[i+1] = temp;
					
				}
			}
			count = count+1;
		}
		for(int j=0; j<arr2.length; j++){
			System.out.print(arr2[j]+" ");
		}
	}
}
