package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {

	public static void main(String args[]){
		File fileout = new File("src/work/out.txt");
		FileReader fr;
		File fileFinal = new File("src/work/final.txt");
		FileWriter fw;
		
		try {
			fr = new FileReader(fileout.getAbsoluteFile());
			fw = new FileWriter(fileFinal.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String data = "", str1="", str2="", str3="";

			while(br.readLine()!=null){
				data = br.readLine();
				System.out.println(data);
				if(data.startsWith("Routed from")){
					str3 = data.substring(data.lastIndexOf('(')+1, data.lastIndexOf(')'));
					data = data.substring(0, data.lastIndexOf("("));
					//System.out.println("data:"+data);
					str2 = data.substring(data.lastIndexOf('[')+1, data.lastIndexOf(']'));
					data = data.substring(0, data.lastIndexOf("[")-1);
					//System.out.println("data:"+data);
					str1 = data.substring(data.indexOf('[')+1, data.indexOf(']'));
					
					//System.out.println("str1 : "+str1+"  "+str2+"  "+str3);
					data="";
					bw.append(str1+","+str2+","+str3+"\n");
				}
				
			}
			br.close();
			bw.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
