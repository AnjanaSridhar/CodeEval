package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	private static List<Integer> l1 = new ArrayList<Integer>(3);
	private static List<Integer> l2 = new ArrayList<Integer>(3);
	private static List<Integer> l3 = new ArrayList<Integer>(3);
	private static int root1, root2, inp1val, inp2val, val3;
	public static void main (String[] args) {
		l1.add(30);
		l1.add(8);
		l1.add(52);
		l2.add(8);
		l2.add(3);
		l2.add(20);
		l3.add(20);
		l3.add(10);
		l3.add(29);
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
						lowestCommonAnces(lineArray[i]);
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

	private static void lowestCommonAnces(String string) {
		// TODO Auto-generated method stub
		
		
		int inp1 = Integer.parseInt(string.substring(0, string.indexOf(" ")));
		int inp2 = Integer.parseInt(string.substring(string.indexOf(" ")+1));
		//System.out.println("----------"+inp1+"---------"+inp2);
		if(l1.contains(inp1)){
			root1=l1.get(0);
			inp1val=1;
		}
		else if(l2.contains(inp1)){
			root1=l2.get(0);
			inp1val=2;
		}
		else{
			root1=l3.get(0);
			inp1val=3;
		}
		if(l1.contains(inp2)){
			root2=l1.get(0);
			inp2val=1;
		}
		else if(l2.contains(inp2)){
			root2=l2.get(0);
			inp2val=2;
		}
		else{
			root2=l3.get(0);
			inp2val=3;
		}
		//System.out.println("root1:"+root1+" root2:"+root2);
		if(root1==root2){
			//System.out.println("first");
			System.out.println(root1);
			return;
		}
		else{
			if(inp1val<inp2val){
				val3 = inp1val;
			}
			else{
				val3 = inp2val;
			}
			
			checkRoots();				
		}
		//System.out.println("last");
		System.out.println(root2);
	}

	private static void checkRoots(){
		/*System.out.println("checkroots");
		System.out.println("inpvals:"+inp1val+"  "+inp2val);*/
		int val = val3;
		switch(val){
		case 1:
			l1.contains(root2);
			root2 = l1.get(0);
			break;
		case 2:
			l2.contains(root2);
			root2 = l2.get(0);
			break;
		case 3:
			l3.contains(root2);
			root2 = l3.get(0);
			break;
		default:
			val3 = inp1val;
			checkRoots();
		}
	}
}
