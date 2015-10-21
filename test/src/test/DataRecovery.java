package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataRecovery {
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
			    	 dataRecovery(lineArray[0]);
			    	
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

	private static void dataRecovery(String string) {
		// TODO Auto-generated method stub
		String[] arr1 = string.split(";");
		String words[] = arr1[0].split(" ");
		String pos[] = arr1[1].split(" ");
		arr1 = null;
		int len = words.length;
		
		Map<Integer,String> map1 = new HashMap<Integer, String>(); 
		for(int i=0; i<pos.length; i++){
			map1.put(Integer.valueOf(pos[i]), words[i]);
		}
		pos=null;
		map1.put(0, words[len-1]);
		words=null;
		String fin = "";
		
		for(int i=1; i<len+1; i++){
			String out = map1.get(i);
			if(out==null){
				out = map1.get(0);
			}
			fin = fin+out+" ";
		}
		System.out.println(fin);
	}

}
