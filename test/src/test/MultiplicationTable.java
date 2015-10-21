package test;

public class MultiplicationTable {

	public static void main(String args[]){
		printMults();
	}

	private static void printMults() {
		for(int i=1; i<13; i++){
			for(int j=1; j<13; j++){
				String val = i*j+"";
				if(val.length()==2){
					val = "  "+val;
				}
				else if(val.length()==1){
					val = "   "+val;
				}
				else{
					val = " "+val;
				}
				System.out.print(val);
			}
			System.out.println();
		}
	}
}
