package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextToNumber {

	static int num = 0;
	static int neg = 1;
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
					textToNumber(lineArray[i]);
					System.out.println(num*neg);
					//System.out.println("----------------");
					num=0;
					neg=1;
				}
				//System.out.println();
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void textToNumber(String string) {
		//System.out.println("input>>>>>>>>>>>>>>>>>>"+string);
		//System.out.println("**************");
		if(string.contains("negative")){
			neg=-1;
		}
		if(string.contains("million")){
			if(string.endsWith("million")){
				millions(string);
				string = "";
			}
			else{
				String str1= string.substring(0, string.indexOf("million")+8);
				string = string.substring(string.indexOf(str1)+str1.length());
				millions(str1);
			}
			
		}
		if(string.contains("thousand")){
			if(string.endsWith("thousand")){
				thousands(string);
				string = "";
			}
			else{
				String str1 = string.substring(0, string.indexOf("thousand")+9);
				string = string.substring(string.indexOf(str1)+str1.length());
				thousands(str1);
			}
		}
		if(string.contains("hundred")){
			int ret = hundreds(string);
			num = num+ret;
		}
		else{
			int ret = hundreds(string);
			num = num+ret;
		}
	}
	private static int hundreds(String str1) {
		// TODO Auto-generated method stub
		int numhun = 0;
		//System.out.println("str1 in hund:"+str1);
		String[] arr = str1.split(" ");
		for(int i=0; i<arr.length; i++){
			//System.out.println("arr val:"+arr[i]);
			if(arr[i].endsWith("ty")){
				numhun = numhun+(getOnes(arr[i])*10);
			}
			else if(arr[i].endsWith("teen")){
				numhun = numhun+(getOnes(arr[i])+10);
			}
			else if(arr[i].equals("hundred")){
				numhun = numhun*100;
			}
			else if(arr[i].equals("thousand")){
				numhun = numhun +0;
			}
			else if(arr[i].equals("million")){
				numhun = numhun +0;
			}
			else{
				numhun=numhun+getOnes(arr[i]);
			}
			//System.out.println("numhun after getting vals:"+numhun);
		}
		return numhun;
		/*num = num+numhun;
		System.out.println("num after hund cal:"+num);*/
		
	}

	private static void thousands(String str1) {
		// TODO Auto-generated method stub
		//System.out.println("str1 in thousand:"+str1);
		int ret = 0;
		String str2 = str1.substring(0, str1.length()-9);
			//System.out.println("str2>>"+str2);
			ret = hundreds(str2);
		//System.out.println("num before thousand:"+num);
		num = num+ret*1000;
		//System.out.println("num after thousand:"+num);
	}

	private static void millions(String str1) {
		// TODO Auto-generated method stub
		//System.out.println("str1 in million:"+str1);
		int ret = 0;
		String str2 = str1.substring(0, str1.length()-8);
			//System.out.println("str2>>"+str2);
			ret = hundreds(str2);
		
		//System.out.println("num before million:"+num);
		num = num+ret*1000000;
		//System.out.println("num after million:"+num);
	}

	

	private static int getOnes(String string){
		if(string.startsWith("tw")){
			return 2;
		}
		else if(string.startsWith("th")){
			return 3;
		}
		else if(string.startsWith("fo")){
			return 4;
		}
		else if(string.startsWith("fi")){
			return 5;
		}
		else if(string.startsWith("si")){
			return 6;
		}
		else if(string.startsWith("seve")){
			return 7;
		}
		else if(string.startsWith("eigh")){
			return 8;
		}
		else if(string.startsWith("nin")){
			return 9;
		}
		else if(string.startsWith("eleve")){
			return 11;
		}
		else if(string.startsWith("one")){
			return 1;
		}
		else if(string.startsWith("te")){
			return 10;
		}
		else {
			return 0;
		}
	}
}
