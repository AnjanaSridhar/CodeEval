package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimeNosInARange {

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
			    	primeNosInARange(lineArray[0]);
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

	private static void primeNosInARange(String string) {
		// TODO Auto-generated method stub
		int range = Integer.valueOf(string).intValue();
		string=null;
		if(range==3){
			System.out.print(2);
			return;
		}
		if(range<3){
			System.out.print("");
			return;
		}
		boolean result = false;
		int count = 0;
		int i=3;
		
		List<Integer> l2 = new ArrayList<Integer>(range);
		l2.add(2);
		
		while(count!=9999){
		
			for(int j=0; j<l2.size(); j++){
				if(i%(l2.get(j))==0){
					result = true;
					break;
				}
				else{
					result = false;
				}
				
			}
			if(result==false){
				
				if(i>range-1){
					count=9999;
				}
				else{
					l2.add(i);
					
				}
			}
			i=i+2;
		}
		String out ="";
		out = l2+"";
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(", ", ",");
		System.out.print(out);
	}
	
}
