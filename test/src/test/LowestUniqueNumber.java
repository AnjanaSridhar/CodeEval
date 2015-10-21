package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowestUniqueNumber {

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
						lowestUniqueNumber(lineArray[i]);
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

	private static void lowestUniqueNumber(String string) {
		// TODO Auto-generated method stub
		//System.out.println(string);
		String[] arr = string.split(" ");
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> dup = new ArrayList<Integer>();
		String temp = "";
		for(int i=0; i<arr.length; i++){
			//System.out.println(l1);
			if(l1.indexOf(arr[i])!=-1){
				temp = temp+arr[i];
			}
			else{
				if(l1.contains(Integer.valueOf(arr[i]))) {
					if(!dup.contains(Integer.valueOf(arr[i]))){
						dup.add(Integer.valueOf(arr[i]));
					}
				}
				else{
					l1.add(Integer.valueOf(arr[i]));
				}
			}
		}
		for(int i=0; i<l1.size(); i++){
			if(temp.contains(l1.get(i)+"")){
				l1.remove(i);
			}
		}
		
		Collections.sort(l1);
		for(int i=0; i<dup.size(); i++){
			l1.remove(l1.indexOf(dup.get(i)));
		}
		if(l1.size()==0){
			System.out.println(0);
			return;
		}
		for(int i=0; i<arr.length; i++){
			if(Integer.valueOf(arr[i])==l1.get(0)){
				System.out.println(i+1);
				return;
			}
		}
	}
}
