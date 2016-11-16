package per.sd.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo1 {
	public static void main(String[] args) {
		input();
	}
	public static void io() throws IOException{
		File file = new File("src/per/sd/io/test.png");
		File file2 = new File("src/per/sd/io/output.png");
		//字节缓冲流(BufferdInputStream / BufferedOutPutStream)
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(file2));
		
		int len = 0;
		byte[] bytes = new byte[1024];
		
		while(-1!=(len=is.read(bytes))){
			os.write(bytes, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}
	public static void input(){
		File file = new File("src/per/sd/io/test.txt");
		if (!file.exists()) {//如果file不存在，就创建一个
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//将文件内容读取到bytes数组中
		byte[] bytes = new byte[1024];
		try {
			InputStream is = new FileInputStream(file);
			//实际读取长度
			int length = 0;
			//当length为-1时表示读取完毕,每次读取最多1024个字节
			while(-1!=(length=is.read(bytes))){
				String string = new String(bytes,0,length);
				System.out.println(string);
			}
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 字节输出流
	 */
	public static void output(){
		File file = new File("src/per/sd/io/source/test.txt");
		//如果文件不存在，会自动创建一个
		String str = "Hello World!\r\n";
		try {
			OutputStream os = new FileOutputStream(file,true);//添加true是为了追加，默认为覆盖
			byte[] bytes = str.getBytes();
			os.write(bytes, 0, bytes.length);
			
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
