package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HappyNumbers {

	private static int num = 0;
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
						happyNumbers(lineArray[i]);
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

	private static void happyNumbers(String string) {
		// TODO Auto-generated method stub
		//int num = Integer.parseInt(string);
		//System.out.println("-----------"+string);
		int count = 0;
		boolean res = false;
		num = Integer.valueOf(string).intValue();
		while(num!=1){
			int sum =0;
			//System.out.println("now num is "+num);
			for(int i=0; i<(num+"").length(); i++){
				/*System.out.println("--------"+i+"-------------");
				System.out.println("len:"+(num+"").length());
				*/
				sum = sum+(Integer.valueOf((num+"").charAt(i)+"").intValue()*Integer.valueOf((num+"").charAt(i)+"").intValue());
				//System.out.println("sum:"+sum);
				count = count+1;
			}
			//System.out.println("count:"+count);
			if(count>15){
				//System.out.println(count);
				res = true;
				break;
			}
			num=sum;
		}
		if(res==false){
			System.out.println(1);
		}
		else{
			System.out.println(0);
		}
			


	}

}
