package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberPairs {
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
						numberPairs(lineArray[i]);
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

	private static void numberPairs(String string) {
		// TODO Auto-generated method stub
		//Map<Integer,Integer> l1 = new HashMap<Integer, Integer>();
		//System.out.println(string);
		String str1 = string.substring(0, string.indexOf(";"));
		int val = Integer.valueOf(string.substring(string.indexOf(";")+1)).intValue();
		String[] arr = str1.split(",");
		List<Integer> l1 = new ArrayList<Integer>();
		for(int i=0; i<arr.length; i++){
			int search = val - Integer.valueOf(arr[i]).intValue();
			if(str1.contains(","+search+",")){
				int small = 0;
				if(Integer.valueOf(arr[i]).intValue()>search){
					small = search;
				}
				else{
					small = Integer.valueOf(arr[i]).intValue();
				}
				if(!l1.contains(small)){
					l1.add(small);
				}
			}
		}
		if(l1.size()==0){
			System.out.print("NULL");
			return;
		}
		Collections.sort(l1);
		for(int i=0; i<l1.size(); i++){
			int large = val - l1.get(i);
			System.out.print(l1.get(i)+","+large);
			if(i<l1.size()-1){
				System.out.print(";");
			}
		}
	}
}
