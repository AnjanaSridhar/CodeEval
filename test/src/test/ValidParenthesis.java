package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidParenthesis {

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
						validParenthesis(lineArray[0]);
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

	private static void validParenthesis(String string) {
		// TODO Auto-generated method stub
		String string1 = string;
		if(string.length()%2!=0){
			System.out.println("False");
			return;
		}
		for(int i=0; i<string.length(); i++){
			System.out.println(">>>"+string.charAt(i));
			if(")}]".contains(string.charAt(i)+"")){
				int index = 0;
				
				if(string.charAt(i)==')'){
					for(int j=i; j>-1; j--){
						if(string.charAt(j)=='('){
							index = j;
							string = string.replace(string.charAt(j), 'X');
							break;
						}
					}
				}
				else if(string.charAt(i)=='}'){
					for(int j=i; j>-1; j--){
						if(string.charAt(j)=='{'){
							index = j;
							string = string.replace(string.charAt(j), 'X');
							break;
						}
					}
				}
				else if(string.charAt(i)==']'){
					for(int j=i; j>-1; j--){
						if(string.charAt(j)=='['){
							index = j;
							string = string.replace(string.charAt(j), 'X');
							break;
						}
					}
				}
				 
				System.out.println("index:"+index);
				if((index-i+1)%2==0){
					string = string.replace(string.charAt(i), 'X');
					System.out.println("now string is:"+string);
					continue;
				}
				else{
					System.out.println("False");
					return;
				}
			}
		}
		string = string.replace("X", "");
		if(string.length()>0){
			System.out.println("False");
		}
		else{
			System.out.println("True");
		}
		System.out.println(string1);
	}

}
