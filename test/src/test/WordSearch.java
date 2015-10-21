package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {

	static String board[][] = new String[][]{{"A", "B", "C", "E"}, {"S", "F", "C", "S"}, {"A", "D", "E", "E"} };
	
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
					wordSearch(lineArray[i]);
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

	private static void wordSearch(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		int x=0, y=0;

		if(!(string.charAt(0)+"").equals(board[0][0])){
			System.out.println("False1");
			return;
		}

		//System.out.println("board length:"+board[0].length+"  "+board[1].length);
		for(int str=1; str<string.length(); str++){
			for(int i=x; i<board[0].length; ){
				for(int j=y; j<board[1].length; j++){
					//System.out.println(board[i+1][j] +"  "+board[i][j+1]+"  "+string.charAt(str));
					if(i!=board[0].length-2){
						//System.out.println(board[i+1][j] +"    "+string.charAt(str));
						if(board[i+1][j].equals(string.charAt(str)+"")){
							//System.out.println("true");
							if(board[0].length-1!=i+1){
								x = i+1;
							}
							y=j;
							//System.out.println("xy:"+x+"  "+y);
							break;
						}
					}
					if(j!=board[1].length-1){
						//System.out.println(board[i][j+1]+"  "+string.charAt(str));
						if(board[i][j+1].equals(string.charAt(str)+"")){
							//System.out.println("true");
							x=i;
							if(board[1].length-1!=j+1){
								y=j+1;
							}
							//System.out.println("xy:"+x+"  "+y);
							break;
						}
					}
					if(i-1>-1){
						//System.out.println(board[i-1][j] +"    "+string.charAt(str));
						if(board[i-1][j].equals(string.charAt(str)+"")){
							//System.out.println("true");
							if(i-1>-1){
								x = i-1;
							}
							y=j;
							//System.out.println("xy:"+x+"  "+y);
							break;
						}
					}
					if(j-1>-1){
						//System.out.println(board[i][j-1]+"  "+string.charAt(str));
						if(board[i][j-1].equals(string.charAt(str)+"")){
							//System.out.println("true");
							x=i;
							if(j-1>-1){
								y=j-1;
							}
							//System.out.println("xy:"+x+"  "+y);
							break;
						}
					}
					if(str==string.length()-1){
						System.out.println("False1");
						return;
					}
				}
				if(str==string.length()-1){
					System.out.println("True1");
					return;
				}
				break;
			}
			
		}
	}
}
