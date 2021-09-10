package test;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteExam4 {

	public static void main(String[] args) {
		try(
				DataInputStream in = new DataInputStream(new FileInputStream("data.txt"));
				){
			int i = in.readInt();
			Boolean bool = in.readBoolean();
			Double d = in.readDouble();
			
			System.out.println(i);
			System.out.println(bool);
			System.out.println(d);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
