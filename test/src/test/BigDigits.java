package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BigDigits {

	
	static String out = "";
	static int count = 0;
	static int numb = 0;
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
						int num=0;
						while(num<5){
							bigDigits(lineArray[i]);
							num = num+1;
							System.out.println();
							numb=0;
						}
						count=0;
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

	private static void bigDigits(String string) {
		// TODO Auto-generatString out = "";
		
		for(int i=0; i<string.length(); i++){
			//System.out.println(string.charAt(i));
			
			if(Character.isDigit(string.charAt(i))){
				numb = numb+1;
				out = getDigit(string.charAt(i));
				System.out.print(out);
			}
		}
		count = count+1;
		if(count==5){
			System.out.println();
			for(int i=0; i<numb; i++){
				System.out.print("-----");
			}
		}
	}

	private static String getDigit(char c) {
		// TODO Auto-generated method stub
		switch(c){
		case '1':
			switch(count){
			case 0:
				return "--*--";
			case 1:
				return "-**--";
			case 2:
				return "--*--";
			case 3:
				return "--*--";
			case 4:
				return "-***-";
				
			}
			break;
		case '2':
			switch(count){
			case 0:
				return "***--";
			case 1:
				return "---*-";
			case 2:
				return "-**--";
			case 3:
				return "*----";
			case 4:
				return "****-";
				
			}
			break;
		case '3':
			switch(count){
			case 0:
				return "***--";
			case 1:
				return "---*-";
			case 2:
				return "-**--";
			case 3:
				return "---*-";
			case 4:
				return "***--";
				
			}
			break;
		case '4':
			switch(count){
			case 0:
				return "-*---";
			case 1:
				return "*--*-";
			case 2:
				return "****-";
			case 3:
				return "---*-";
			case 4:
				return "---*-";
				
			}
			break;
		case '5':
			switch(count){
			case 0:
				return "****-";
			case 1:
				return "*----";
			case 2:
				return "***--";
			case 3:
				return "---*-";
			case 4:
				return "***--";
				
			}
			break;
		case '6':
			switch(count){
			case 0:
				return "-**--";
			case 1:
				return "*----";
			case 2:
				return "***--";
			case 3:
				return "*--*-";
			case 4:
				return "-**--";
				
			}
			break;
		case '7':
			switch(count){
			case 0:
				return "****-";
			case 1:
				return "---*-";
			case 2:
				return "--*--";
			case 3:
				return "-*---";
			case 4:
				return "-*---";
				
			}
			break;
		case '8':
			switch(count){
			case 0:
				return "-**--";
			case 1:
				return "*--*-";
			case 2:
				return "-**--";
			case 3:
				return "*--*-";
			case 4:
				return "-**--";
				
			}
			break;
		case '9':
			switch(count){
			case 0:
				return "-**--";
			case 1:
				return "*--*-";
			case 2:
				return "-***-";
			case 3:
				return "---*-";
			case 4:
				return "-**--";
				
			}
			break;
		case '0':
			switch(count){
			case 0:
				return "-**--";
			case 1:
				return "*--*-";
			case 2:
				return "*--*-";
			case 3:
				return "*--*-";
			case 4:
				return "-**--";
				
			}
			break;
			
		}
		return "";
	}
}
