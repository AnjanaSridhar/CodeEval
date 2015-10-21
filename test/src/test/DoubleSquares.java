package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoubleSquares {

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
						find(lineArray[i]);
						
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

	private static void find(String string) {
		// TODO Auto-generated method stub
		//System.out.println("input>>"+string);
		
		if(Integer.valueOf(string)==0 || Integer.valueOf(string)==1){
			System.out.println(1);
			return;
		}
		
		int mid = Integer.valueOf(string)/2;
		System.out.println(mid);
		/*List<Integer> l1 = new ArrayList<Integer>(Integer.parseInt(string));
		for(int i=0; i<Integer.valueOf(string).intValue(); i++){
			l1.add(i*i);
		}
		int count = 0;
		//System.out.println(l1);
		String val = "";
		for(int i=0; i<l1.size(); i++){
			if(val.contains(l1.get(i)+"")){
				continue;
			}
			if(l1.contains(Integer.valueOf(string)-l1.get(i))){
				//System.out.println(Integer.valueOf(string)-l1.get(i)+" -- "+l1.get(i));
				val = val+(Integer.valueOf(string)-l1.get(i))+""+l1.get(i);
				count++;
			}
		}
		//System.out.println(val);
		System.out.println(count);*/
	}
}
