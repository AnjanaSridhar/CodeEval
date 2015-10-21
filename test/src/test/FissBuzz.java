package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FissBuzz {

	public static void main (String[] args) {
	    File file = new File(args[0]);
	    BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String line;
	    int pos1=0, pos2=0, len=0;
	    try {
			while ((line = in.readLine()) != null) {
			    String[] lineArray = line.split("\\s");
			    if (lineArray.length > 0) {
			        //Process line of input Here
			    	 pos1 = Integer.valueOf(lineArray[0]).intValue();
			    	 pos2 = Integer.valueOf(lineArray[1]).intValue();
			    	 len = Integer.valueOf(lineArray[2]).intValue();
			    	
			    }
			    applyFizzBuzz(pos1, pos2, len);
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

		private static void applyFizzBuzz(int pos1, int pos2, int len) {
			// TODO Auto-generated method stub
			for(int i=1; i<len+1; i++){
				if(i%pos1==0  && i%pos2==0){
					System.out.print("FB ");
				}
				else if(i%pos1==0){
					System.out.print("F ");
				}
				else if(i%pos2==0){
					System.out.print("B ");
				}
				else{
					System.out.print(i+" ");
				}
			}
		}
	
}
