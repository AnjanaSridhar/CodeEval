package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LowerCase {

	public static void main (String[] args) throws FileNotFoundException {
		//File file = new File(args[0]);
		File file = new File("C:/Local/input1.txt");
		Scanner file1 = new Scanner(file);
		while(file1.hasNext()){
			String line = file1.nextLine();
			System.out.println(line.toLowerCase());
		}
		file1.close();
	}
}
