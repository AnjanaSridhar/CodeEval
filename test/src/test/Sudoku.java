package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {

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
						sudoku(lineArray[i]);
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

	private static void sudoku(String string) {
		// TODO Auto-generated method stub
		String[] strarr = string.split(";");
		int[][] intarr = new int[Integer.valueOf(strarr[0]).intValue()][Integer.valueOf(strarr[0]).intValue()];
		String[] arr = strarr[1].split(",");
		//System.out.println(arr.length);
		//System.out.println(intarr[0].length+"  "+intarr[1].length);
		int k=0;
		for(int i=0; i<intarr[0].length; i++){
			for(int j=0; j<intarr[1].length; j++){
				intarr[i][j] = Integer.valueOf(arr[k]).intValue();
				
				k++;
			}
			
		}
		
		int len =Integer.parseInt(strarr[0]);
		sudoking(intarr, len);
		
		
		
		
	}
	
	private static void sudoking(int intarr[][], int len){
		System.out.println("-------------------");
		int sections = (int) Math.sqrt(len);
		int count =0;
		int sum = 0;
		int i=0, j=0;
		for( i=0; i<intarr[0].length; i++){
			for( j=0;j<intarr[1].length; j++){
				if(count==1){
					sum = sum+intarr[j][i];
					//System.out.println(intarr[i][j]);
				}
				else{
					sum = sum+intarr[i][j];
					//System.out.println(intarr[i][j]);
				}
			}
			if(sum!=10){
				System.out.println("False");
				return;
			}
			else{
				sum = 0;
			}
			if(i==intarr[0].length-1 && count<2){
				count = count+1;
				i=0; j=0;
				
			}
		}
		sum=0;
		count = 0;
		int ind = 0;
		int ind2 = 0;
		int length1=sections, length2 =sections;
		//System.out.println("---"+length1);
		for(i=ind; i<length1; i++){
			//System.out.println("---------------i:"+i);
			for(j=ind2; j<length2; j++){
				//System.out.println("---------------j:"+j);
				sum = sum+intarr[i][j];
				//System.out.println(intarr[i][j]);
			}
			count = count+1;
			//System.out.println("    count>>>>>>>>"+count);
			if(i==length1-1){
				if(count==len*2){
					break;
				}
				if(sum!=10){
					System.out.println("False");
					return;
				}
				else{
					sum=0;
				}
				length1 = length1+sections;
				
				if(i==len-1){
					ind = -1;
					i=ind;
					ind2 = j;
					length1 = sections;
					length2 = length2+sections;
					//System.out.println("asdsadsadasds");
					//break;
				}
				//System.out.println(">>"+length1+"  "+i+"  "+length2+"  "+j);
			}
			
		}
		
		//System.out.println("outttttttttttt");
		if(sum>10){
			System.out.println("False");
		}
		System.out.println("True");
	}
}
