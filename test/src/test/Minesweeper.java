package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Minesweeper {

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
						mines(lineArray[i]);
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

	private static void mines(String string) {
		//System.out.println("-----------------------");
		// TODO Auto-generated method stub
		int m = Integer.valueOf(string.substring(0, string.indexOf(","))).intValue();
		int n = Integer.valueOf(string.substring(string.indexOf(",")+1, string.indexOf(";"))).intValue();
		string = string.substring(string.indexOf(";")+1);
		
		int k=0;
		String[][] mat = new String[m][n];
		String[][] res = new String [m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){				
				mat[i][j] = string.charAt(k)+"";
				k=k+1;
			}
		}
		int num=0;
		//System.out.println("cal");
		for(int i=0; i<m; i++){
			//System.out.println("i>>"+i);
			for(int j=0; j<n; j++){				
				//System.out.println("j>>"+j +mat[i][j]);
				if(!mat[i][j].equals("*")){
					//System.out.println("not star");
					if(j+1!=n){
						if(mat[i][j+1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 1 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					//System.out.println("j-1:"+(j-1));
					
					if(j-1>-1){
						//System.out.println("in j-1");
						if(mat[i][j-1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 2 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(i+1!=m){
						if(mat[i+1][j].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 3 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(i-1>-1){
						if(mat[i-1][j].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 4 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(j+1!=n && i+1!=m){
						if(mat[i+1][j+1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 5 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(j-1>-1 && i-1>-1){
						if(mat[i-1][j-1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 6 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(i+1!=m && j-1>-1){
						if(mat[i+1][j-1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 7 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					if(i-1>-1 && j+1!=n){
						if(mat[i-1][j+1].equals("*")){
							//System.out.println("inp>>>"+mat[i][j]+" 8 J:"+j+" I:"+i);
							num = num+1;
						}
					}
					res[i][j] = num+"";
					num=0;
				}
				if(mat[i][j].equals("*")){
					res[i][j]="*";
				}
				//System.out.print(mat[i][j]+" ");
			}
			//System.out.println();
		}
		//System.out.println("num:------------------------------");
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){				
				System.out.print(res[i][j]);
				
			}
		}
	}
}
