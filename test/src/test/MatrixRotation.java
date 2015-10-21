package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixRotation {

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
						matrixRotation(lineArray[i]);
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

	private static void matrixRotation(String string) {
		// TODO Auto-generated method stub
		string = string.replace(" ", "");
		int len = (int) Math.sqrt(string.length());
		
		String[][] mat = new String[len][len];
		int ind = 0;
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				mat[i][j] = string.charAt(ind)+"";
				ind++;
				if(ind>string.length()-1){
					break;
				}
			}
		}
		
		int j = 0,  count=0;
		for(int i=len-1; i>-1; ){
			for(j=0; j<len; i--){
				if(i<0){
					i = len-1;
					j++;
				}
				if(count==string.length()){
					return;
				}
				System.out.print(mat[i][j]+" ");
				count = count+1;
			}
		}
		
		
	}
}
