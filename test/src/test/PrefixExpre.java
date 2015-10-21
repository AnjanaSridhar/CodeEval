package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class PrefixExpre {

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
						prefixExpre(lineArray[i]);

					}
					System.out.println();
				
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void prefixExpre(String string) {
		// TODO Auto-generated method stub
		String[] arr = string.split(" ");
		Stack<String> st1 = new Stack<String>();
		Stack<String> st2 = new Stack<String>();
		for(int j=0; j<arr.length; j++){
			if(IsSymbol(arr[j])){
				st1.push(arr[j]);
			}
			else{
				st2.push(arr[j]);
			}
		}
		arr=null;
		double res=0;
		while(st1.size()!=0){
			String symb = st1.pop();
			double val1 = Double.valueOf((st2.get(0)));
			double val2 = Double.valueOf((st2.get(1)));
			switch(symb){
			case "*":
				res = val1*val2;
				break;
			case "+":
				res = val1+val2;
				break;
			case "/":
				res = val1/val2;
				break;
	
			}
			st2.remove(0);
			st2.remove(0);
			st2.add(0, res+"");
		}
		System.out.print(Double.valueOf(st2.pop()).intValue());
	}


	private static boolean IsSymbol(String st1){
		if(("*/+").contains(st1)){
			return true;
		}
		return false;
	}
}
