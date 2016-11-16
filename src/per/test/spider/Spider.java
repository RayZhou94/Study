package per.test.spider;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {
	//img标签的正则表达式
	//private final static String IMGURL = "<img\\s+src=\"(.*)\"\\s+>";
	private final static String IMGURL = "<img[\\s]+src=[\\s]*\"(http:\"?.*?\"|>|\\s+)";
	public static final Queue urlqueue = new LinkedBlockingDeque<>();
	
	public static final Queue imgqueue = new LinkedBlockingDeque<>();
	
	public static void main(String[] args) {
		String url ="http://www.nipic.com/index.html";
		getURL(url);
	}
	public static void getURL(String url){
		urlqueue.add(url);
		BufferedReader reader = null;
		try {
			URL newurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) newurl.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while (null !=(line = reader.readLine())) {
				System.out.println(line+"\n");
				String regex = "\"(http://[a-zA-Z0-9]{0,10}.[a-zA-Z]{0,10}.com[^\"&&^/]*)\"";
				Matcher matcher = Pattern.compile(regex).matcher(line);
				while (matcher.find()) {
					//urlqueue.add(matcher.group(1));
					io(matcher.group(1));
					getIMGURL(matcher.group(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public static void getIMGURL(String url){
		BufferedReader reader = null;
		try {
			URL newurl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) newurl.openConnection();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while (null !=(line = reader.readLine())) {
				Matcher matcher = Pattern.compile(IMGURL).matcher(line.trim());
				while (matcher.find()) {
					Matcher matcher2 = Pattern.compile("(.*)\"").matcher(matcher.group(1));
					while (matcher2.find()) {
						//imgqueue.add(matcher2.group(1));
						download(matcher2.group(1));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public static void getIMGURL(){
		while (urlqueue.peek() != null) {
			BufferedReader reader = null;
			try {
				URL newurl = new URL((String) urlqueue.poll());
				HttpURLConnection connection = (HttpURLConnection) newurl.openConnection();
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line = null;
				while (null !=(line = reader.readLine())) {
					Matcher matcher = Pattern.compile(IMGURL).matcher(line.trim());
					while (matcher.find()) {
						Matcher matcher2 = Pattern.compile("(.*)\"").matcher(matcher.group(1));
						while (matcher2.find()) {
							System.out.println(matcher2.group(1));
							download(matcher2.group(1));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (null != reader) {
					try {
						reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	public static void download(String imgurl){
		Matcher matcher = Pattern.compile("/([^/]*.[a-zA-Z]+$)").matcher(imgurl);
		String str = null;
		while (matcher.find()) {
			str = matcher.group(1);
		}
		//System.out.println(str);
		BufferedOutputStream bos = null;
		InputStream bis = null;
		try {
			URL url = new URL(imgurl);
			//HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			bis = url.openStream();
			bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\shallowdream\\Desktop\\pic\\"+str)));
			int length = 0;
			byte [] bytes = new byte[1024];
			while (-1!=(length=bis.read(bytes,0,bytes.length))) {
				bos.write(bytes, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (bis!=null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos!=null) {
				try {
					bos.flush();
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void io(String str){
		BufferedWriter writer = null; 
		try {
			writer = new BufferedWriter(new FileWriter(new File("src/per/test/test2.txt"),true));
			writer.write(str + "\n");
		} catch (Exception e) {
			System.out.println("错了");
		}finally{
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
