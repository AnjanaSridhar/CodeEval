package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReverseGroups {

	static String out2 = "";
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
			    String[] lineArray = line.split("\\s");
			    for(int i=0; i<lineArray.length; i++) {
			        //Process line of input Here
			    	reveresGroups(lineArray[i]);
			    	out2="";
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


	private static void reveresGroups(String num) {
		// TODO Auto-generated method stub
		//String[] arr1 = num.split(";");
		//num=null;
		int len = Integer.valueOf(num.substring(num.lastIndexOf(";")+1));
		//System.out.println("num>>"+len);
		String[] nums = num.substring(0, num.indexOf(";")).split(",");
		
		int count = 0;
		List<String> l1 = new ArrayList<String>(len);
		for(int i=0; i<nums.length; i++){
			
			if(count<len){
				//System.out.println("nums val:"+nums[i]);
				l1.add(nums[i]);
				count=count+1;
				///System.out.println(l1);
			}
			//System.out.println("count>>"+count);
			if(count==len){
				//System.out.println(l1);
				reverse(l1);
				count=0;
				l1.clear();
			}
		}
		//String res[] = reverse(arr1);
		//List<String> l1 = new ArrayList<String>(nums.length);
		/*for(int i=0; i<res.length; i++){
			l1.add(res[i]);
		}
		for(int i=res.length; i<nums.length; i++){
			l1.add(nums[i]);
		}*/
		
		String out = l1+"";
		//System.out.println(l1);
		out = out.replace("[", "");
		out = out.replace("]", "");
		out = out.replace(", " , ",");
		out2 = out2.substring(1);
		System.out.print(out2);
		if(out.length()>0){
			System.out.print(",");
		}
		System.out.print(out);
		
	}


	private static String[] reverse(List<String> arr4) {
		// TODO Auto-generated method stub
		String[] arr3 = new String[arr4.size()];
		//System.out.println("arr size:"+arr4.size());
		for(int i=arr4.size()-1; i>-1; i--){
			//System.out.println("value:"+(arr4.size()-1-i));
			arr3[(arr4.size()-1-i)] = arr4.get(i);
		}
		for(int i=0; i<arr3.length; i++){
			out2 = out2+","+arr3[i];
		}
		//System.out.println();
		return arr3;
	}
}