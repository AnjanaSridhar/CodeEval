package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumToText {

	static boolean belowTwenty = false;
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
					String ret = NumToText(lineArray[0]);
					System.out.println(ret+"Dollars");
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

	private static String NumToText(String string) {
		// TODO Auto-generated method stub
		Integer act = Integer.valueOf(string);
		String ret="";
		if(act==0){
			return "Zero";
		}
		int len = (act.toString()).length();
		switch (len) {
		case 1:
			ret = onesFunc(string);
			return ret;
		case 2:
			ret = tens(string);
			ret = ret+onesFunc(string.charAt(1)+"");
			ret = ret.replace("$", "");
			return ret;
		case 3:
			ret = string.substring(1, 3);
			ret = onesFunc(string.charAt(0)+"")+" "+tens(ret)+
					onesFunc(string.charAt(2)+"");
			break;
		case 4:
			ret = string.substring(2, 4);
			ret = onesFunc(string.charAt(0)+"")+" "+
					onesFunc(string.charAt(1)+"")+" "+tens(ret)+
					onesFunc(string.charAt(3)+"");
			break;
		case 5:
			ret = string.substring(3, 5);
			String sub1 = string.substring(0, 2);
			ret = tens(sub1)+onesFunc(string.charAt(1)+"")+" "+
					onesFunc(string.charAt(2)+"")+" "+tens(ret)+
					onesFunc(string.charAt(4)+"");
			break;
		case 6:
			ret = string.substring(4, 6);
			sub1 = string.substring(1, 3);
			ret = onesFunc(string.charAt(0)+"")+" "+tens(sub1)+
					onesFunc(string.charAt(2)+"")+" "+
					onesFunc(string.charAt(3)+"")+" "+tens(ret)+
					onesFunc(string.charAt(5)+"");
			break;
		case 7:
			ret = string.substring(5, 7);
			String sub2 = string.substring(2, 4);
			sub1 = string.substring(0, 2);
			ret = onesFunc(sub1.charAt(0)+"")+" "+onesFunc(string.charAt(1)+"")+
					" "+tens(sub2)+
					onesFunc(string.charAt(3)+"")+" "+
					onesFunc(string.charAt(4)+"")+" "+tens(ret)+
					onesFunc(string.charAt(6)+"");
			break;
		case 8:
			ret = string.substring(6, 8);
			sub2 = string.substring(3, 5);
			sub1 = string.substring(0, 2);
			ret = tens(sub1)+onesFunc(sub1.charAt(1)+"")+" "+onesFunc(string.charAt(2)+"")+
					" "+tens(sub2)+
					onesFunc(string.charAt(4)+"")+" "+
					onesFunc(string.charAt(5)+"")+" "+tens(ret)+
					onesFunc(string.charAt(7)+"");
			break;
		case 9:
			ret = string.substring(7, 9);
			sub2 = string.substring(4, 6);
			sub1 = string.substring(1, 3);
			ret = onesFunc(string.charAt(0)+"")+" "+
					tens(sub1)+onesFunc(string.charAt(2)+"")+
					" "+onesFunc(string.charAt(3)+"")+
					" "+tens(sub2)+
					onesFunc(string.charAt(5)+"")+" "+
					onesFunc(string.charAt(6)+"")+" "+tens(ret)+
					onesFunc(string.charAt(8)+"");
			break;

		default:
			break;

		}
		ret = naming(ret);
		return ret;
	}

	private static String naming(String ret){
		String[]str = ret.split(" ");
		String rete = "";
		switch(str.length){
		case 2:  rete =  str[0]+"Hundred"+str[1];
		break;
		case 3:  rete = str[0]+"Thousand"; 
		if(!str[1].contains("$")){
			rete = rete+str[1]+"Hundred";
		}
		rete = rete + str[2];

		break;
		case 4:
			rete = str[0]+"Hundred";
			if(!str[1].contains("$")){
				rete = rete+str[1];
			}
			rete = rete+"Thousand"+str[2];
			if(!str[2].contains("$")){
				rete = rete+"Hundred";
			}
			rete = rete+str[3];
			break;
		case 5:
			rete = str[0]+"Million";
			if(!str[1].contains("$")){
				rete = rete+str[1]+"Hundred";
			}

			if(!str[2].contains("$")){
				rete = rete+str[2]+"Thousand";
			}
			if(!str[3].contains("$")){
				rete = rete+str[3]+"Hundred";
			}
			rete = rete+str[4];
			break;
		case 6:
			rete = str[0]+"Hundred";
			rete = rete+str[1]+"Million";

			if(!str[2].contains("$")){
				rete = rete+str[2]+"Hundred";
			}
			if(!str[3].contains("$$")){
				rete = rete+str[3];
			}
			if(!(str[2]+str[3]).equals("$$$")){
				rete = rete+"Thousand";
			}
			if(!str[4].contains("$")){
				rete = rete+str[4]+"Hundred";
			}
			rete = rete+str[5];
			break;
		}
		rete = rete.replace("$", "");
		return rete;
	}

	private static String tens(String string) {
		// TODO Auto-generated method stub
		String ret = onesFunc(string.charAt(0)+"");
		if(ret.equals("")){
			return "$";
		}
		switch(ret.charAt(0)+""){
		case "T":
			if(ret.equals("Three")){
				return "Thirty";
			}
			if(ret.equals("Two")){
				return "Twenty";
			}
		case "O":
			ret = onesFunc(string.charAt(1)+"");
			belowTwenty = true;
			switch(ret){
			case "$":return "Ten";
			case "Two": return "Twelve";
			case "Three":return "Thirteen";
			case "One":return "Eleven";
			case "Five": return "Fifteen";
			case "Eight":return "Eighteen";
			default: return ret+"teen";

			}

		case "F":
			if(ret.equals("Five")){
				return "Fifty";
			}
			if(ret.equals("Four")){
				return "Forty";
			}

		case "E":
			return "Eighty";

		case "N":
			return "Ninety";
		case "S":
			if(ret.equals("Seven")){
				return "Seventy";
			}
			if(ret.equals("Six")){
				return "Sixty";
			}	
		}
		return "$";

	}



	private static String onesFunc(String string) {
		// TODO Auto-generated method stub
		if(belowTwenty==true){
			belowTwenty = false;
			return "";
		}
		int num = Integer.valueOf(string);
		switch (num) {
		case 1:
			return("One");
		case 2:
			return("Two");
		case 3:
			return("Three");
		case 4:
			return("Four");
		case 5:
			return("Five");

		case 6:
			return("Six");
		case 7:
			return("Seven");
		case 8:
			return("Eight");
		case 9:
			return("Nine");


		}
		return "$";
	}
}
