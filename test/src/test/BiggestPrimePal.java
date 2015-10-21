package test;

import java.util.ArrayList;
import java.util.List;

public class BiggestPrimePal {

	public static void main(String[] args){
		biggestPrimePalindrome();
	}

	private static void biggestPrimePalindrome() {
		// Finding the biggest prime palindrome
		boolean result = false;
		int count = 0;
		int i=3, fin = 0;
		List l2 = new ArrayList<Integer>();
		l2.add(2);
		
		while(count!=999){
		
			for(int j=0; j<l2.size(); j++){
				if(i%((Integer)l2.get(j))==0){
					result = true;
					break;
				}
				else{
					result = false;
				}
				
			}
			if(result==false){
				boolean pal = checkIsPalindrome(i);
				if(pal){
					fin = i;
				}
				l2.add(i);
				count=count+1;
			}
			i=i+2;
		}
		System.out.println(fin);
	}

	private static boolean checkIsPalindrome(Integer in) {
		// TODO Auto-generated method stub
		String str = in.toString();
		String pal = "";
		for(int i=str.length()-1; i>-1; i--){
			pal = pal+str.charAt(i);
		}
		if(str.equals(pal)){
			return true;
		}
		return false;
	}
	
}
