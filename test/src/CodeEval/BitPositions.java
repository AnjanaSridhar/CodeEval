package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BitPositions {

	public static void main (String[] args) {
		File file = new File("C:/Local/input1.txt");
		//File file = new File(args[0]);
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
						bitPos(lineArray[i]);
					
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

	private static void bitPos(String string) {
		// TODO Auto-generated method stub
		int val = Integer.valueOf(string.substring(0, string.indexOf(","))).intValue();
		string = string.substring(string.indexOf(",")+1);
		int bit1 = Integer.valueOf(string.substring(0, string.indexOf(","))).intValue();
		string = string.substring(string.indexOf(",")+1);
		int bit2 = Integer.valueOf(string).intValue();
		String bits = Integer.toBinaryString(val);
		if(bits.charAt(bits.length()-bit1)==bits.charAt(bits.length()-bit2)){
			System.out.println("true");
		}
		else{
			System.out.println(false);
		}
	}

}
