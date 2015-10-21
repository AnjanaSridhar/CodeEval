package CodeEval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompressSeq {

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
					compressSeq(lineArray[0]);
						System.out.println();
					

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

	private static void compressSeq(String string) {
		// TODO Auto-generated method stub
		String[] arr1 = string.split(" ");
		if(arr1.length==1){
			//System.out.print(arr1[0]);
		}
		if(arr1.length==1){
			System.out.print("");
		}
		int[] arr= new int[arr1.length];
		List<Integer> l1 = new ArrayList<Integer>();
		for(int i=0; i<arr1.length; i++){
			arr[i] = Integer.valueOf(arr1[i]);
		}
		arr1 = null;
		int temp = arr[0];
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]==temp){
				temp = arr[i];
				count = count+1;
			}
			else{
				if(count==0){
					l1.add(1);
					l1.add(temp);
				}
				else{
					l1.add(count);
					l1.add(temp);
				}
				
				temp=arr[i];
				count = 1;
			}


		}
		l1.add(count);
		l1.add(temp);
		String out = l1+"";
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(",", "");
		System.out.print(out);
	}
}
