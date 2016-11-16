package per.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YouKu {
	public static Queue queue = new ArrayBlockingQueue<>(1000);
	public static void main(String[] args) {
		youku("http://www.tooopen.com/img/87_312.aspx");
	}
	
	public static void jiexi(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("src/per/test/test2.txt")));
			String line = null;
			while (null != (line = reader.readLine())) {
				getURL(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	public static void getURL(String line){
		String regex = "\"(http://[a-zA-Z0-9]{0,10}.[a-zA-Z]{0,10}.com[^\"]*)\"";
		Matcher matcher = Pattern.compile(regex).matcher(line);
		while (matcher.find()) {
			queue.add(matcher.group(1));
		}
	}
	public static void youku(String imgurl){
		BufferedReader reader = null;
		BufferedWriter writer = null; 
		try {
			writer = new BufferedWriter(new FileWriter(new File("src/per/test/test2.txt"),true));
			URL url = new URL(imgurl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while (null !=(line = reader.readLine())) {
				writer.write(line + "\n");
			}
		} catch (Exception e) {
			System.out.println("错了");
		}finally{
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (null != writer) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
