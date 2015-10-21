package test;

import java.nio.ByteOrder;

public class Endianness {

	public static void main (String[] args) {
		if(ByteOrder.nativeOrder().toString().equals("LITTLE_ENDIAN")){
			System.out.println("LittleEndian");
		}
		else{
			System.out.println("BigEndian");
		}
	}
}
