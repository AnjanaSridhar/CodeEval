package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountingPrimes {

	static int sum = 0;
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
				for(int i=0; i<lineArray.length; i++) {
					//Process line of input Here
					countingPrimes(lineArray[i]);
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

	private static void countingPrimes(String string) {
		// TODO Auto-generated method stub
		String[] arr = string.split(",");
		int start = Integer.valueOf(arr[0]).intValue();
		int last = Integer.valueOf(arr[1]).intValue();
		arr=null;
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		addToList(3, start, l1);
		int strt = start;
		if(start%2==0){
			start = start+1;
		}
		sum=0;
		addToList(start, last, l1);
		if(strt==2){
			sum=sum+1;
		}
		System.out.println(sum);
	}
	private static void addToList(int start, int last, List<Integer> l1){
		//System.out.println("in add:"+start+" "+last+"------");
		//System.out.println(">>>>>"+l1);
		boolean result = false;
		for(int i=start; i<last+1; i=i+2){

			for(int l =0; l<l1.size(); l++){
				//System.out.println("i:"+i+" l>>"+l1.get(l));
				//System.out.println("val is:"+i%l1.get(l));
				if(i!=l1.get(l)){
					if(i%l1.get(l)==0){
						result = false;
						break;
					}
					else{
						result = true;
					}
				}
			}
			if(result==true){
				//System.out.println("adding>>>"+i);
				l1.add(i);
				sum = sum+1;

			}
		}
	}

}
