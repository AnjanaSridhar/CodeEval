package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadMore {

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
			    String[] lineArray = line.split("  ");
			    for(int i=0; i<lineArray.length; i++){
			    	limitWords(lineArray[i]);
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

	private static void limitWords(String story) {
		// TODO Auto-generated method stub
		String readMore = "... <Read More>";
		if(story.length()>55){
			story = story.substring(0, 40);
			if(story.contains(" ")){
				story = story.substring(0, story.lastIndexOf(" "));
			}
			story = story.trim();
			story = story+readMore;
		}
		System.out.println(story);
	}
}
