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
		/*System.out.println(p01+p11+p21+p31+p41+p51+p61+p71+p81+p91);
		System.out.println(p02+p12+p22+p32+p42+p52+p62+p72+p82+p92);
		System.out.println(p03+p13+p23+p33+p43+p53+p63+p73+p83+p93);
		System.out.println(p04+p14+p24+p34+p44+p54+p64+p74+p84+p94);
		System.out.println(p05+p15+p25+p35+p45+p55+p65+p75+p85+p95);
		System.out.println("--------------------------------------------------");*/
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
			/*p11 = "--*--";
			p12 = "-**--";
			p13 = "--*--";
			p14 = "--*--";
			p15 = "-***-";*/
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
			/*p21 = "***--";
			p22 = "---*-";
			p23 = "-**--";
			p24 = "*----";
			p25 = "****-";*/
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
			/*p31 = "***--";
			p32 = "---*-";
			p33 = "-**--";
			p34 = "---*-";
			p35 = "***--";*/
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
			/*p41 = "-*---";
			p42 = "*--*-";
			p43 = "****-";
			p44 = "---*-";
			p45 = "---*-";*/
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
			/*p51 = "****-";
			p52 = "*----";
			p53 = "***--";
			p54 = "---*-";
			p55 = "***--";*/
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
			/*p61 = "-**--";
			p62 = "*----";
			p63 = "***--";
			p64 = "*--*-";
			p65 = "-**--";*/
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
			/*p71 = "****-";
			p72 = "---*-";
			p73 = "--*--";
			p74 = "-*---";
			p75 = "-*---";*/
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
			/*p81 = "-**--";
			p82 = "*--*-";
			p83 = "-**--";
			p84 = "*--*-";
			p85 = "-**--";*/
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
			/*p91 = "-**--";
			p92 = "*--*-";
			p93 = "-***-";
			p94 = "---*-";
			p95 = "-**--";*/
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
			/*p01 = "-**--";
			p02 = "*--*-";
			p03 = "*--*-";
			p04 = "*--*-";
			p05 = "-**--";*/
			break;
			
		}
		return "";
	}
}
