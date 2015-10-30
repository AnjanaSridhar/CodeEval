package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShortestRepetition {

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
						shortestRep(lineArray[i]);
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

	private static void shortestRep(String string) {
		// TODO Auto-generated method stub
		String temp="";
		int count = 0;
		boolean done = false;
		for(int i=0; i<string.length(); i++){
			
			if(!temp.contains(string.charAt(i)+"")){
				temp = temp+string.charAt(i);
			}
			else{
				
				temp = temp.replace(string.charAt(i)+"", "");
				count = count+1;
				if(temp.length()==0){
					System.out.println(count);
					done = true;
					break;
				}
			}
		}
		if(done==false){
			System.out.println(string.length());
		}
		
	}
}
