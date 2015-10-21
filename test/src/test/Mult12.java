package test;

public class Mult12 {

	public static void main(String args[]){
		for(int j=1; j<13; j++){
			for(int i=1; i<13; i++){

				String val = i*j+"";
				switch(val.length()){
				case 1:val = "   "+val;
				break;
				case 2:val = "  "+val;
				break;
				case 3: val = " "+val;
				break;
				}
				System.out.print(val);

			}
			System.out.println();
		}
	}
}
