package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PascalTriangle {

	static int count = 1, depth=0;
	static int[][] arr;
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
					depth = Integer.valueOf(lineArray[i]);
					arr = new int[Integer.valueOf(lineArray[i])][Integer.valueOf(lineArray[i])];
					for(int i1=0; i1<Integer.valueOf(lineArray[i]); i1++){
						for(int j=0; j<Integer.valueOf(lineArray[i]); j++){
							if(j==0){
								arr[i1][j] = 1;
							}
							else{
								arr[i1][j] = 0;
							}

						}
					}
					arr[0][0] =1;
					
					pascalTriangle();

				}
				System.out.println();
				count=1;
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void pascalTriangle() {
		// TODO Auto-generated method stub

		for(int i=1; i<count+1; i++){
			for(int j=0; j<count; j++){
				if(count>=Integer.valueOf(depth)){
					for(int i1=0; i1<Integer.valueOf(depth); i1++){
						for(int k=0; k<Integer.valueOf(depth); k++){
							if(arr[i1][k]!=0){
								System.out.print(arr[i1][k]+" ");
							}
						}
					}
					return;
				}
				arr[i][j+1] = arr[i-1][j]+arr[i-1][j+1];
				

			}
			count++;
		}
		

	}
}
