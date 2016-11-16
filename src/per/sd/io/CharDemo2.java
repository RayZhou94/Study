package per.sd.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class CharDemo2 {
	public static void main(String[] args) throws IOException {
		output();
	}
	public static void input(){
		File file = new File("src/per/sd/io/source/test.txt");
		File file2 = new File("src/per/sd/io/source/output.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2,true));
			
			String line = null;
			while (null!=(line=reader.readLine())) {
				System.out.println(line);
				writer.write(line);
				//换行
				writer.newLine();
			}
			writer.flush();
			writer.close();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void output() throws IOException{
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("src/per/sd/io/source/test.txt"),true)));
		dos.writeDouble(2.3);
		dos.writeInt(3);
		dos.flush();
		dos.close();
		
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("src/per/sd/io/source/test.txt"))));
		System.out.println(dis.readDouble());
		System.out.println(dis.readInt());
		dis.close();
	}
}
