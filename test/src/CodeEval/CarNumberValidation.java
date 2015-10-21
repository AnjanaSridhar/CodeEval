package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarNumberValidation {

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
						cardNumberValidation(lineArray[i]);
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

	private static void cardNumberValidation(String string) {
		// TODO Auto-generated method stub
		//System.out.println("------------");
		string = string.replace(" ", "");
		int[] intarr = new int[string.length()];
		for(int i=0; i<string.length(); i++){
			intarr[i] = Integer.valueOf(string.charAt(i)+"");
			//System.out.println(string.charAt(i)+"  "+intarr[i]);
		}
		int total = 0;
		for(int i=intarr.length-2; i>-1; i=i-2){
			//System.out.println(">>>"+intarr[i]);
			int sum = intarr[i]+intarr[i];
			if(sum>9){
				String num = sum+"";
				sum = Integer.valueOf(num.charAt(0)+"")+Integer.valueOf(num.charAt(1)+"");
			}
			//System.out.println(sum);
			intarr[i] = sum;
			total = total+sum;
		}
		for(int i=intarr.length-1; i>-1; i=i-2){
			total = total+intarr[i];
			
		}
		if(total%10==0){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
		//System.out.println(sum);
	}
}
