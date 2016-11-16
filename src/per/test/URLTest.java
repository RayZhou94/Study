package per.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLTest {
	public static void main(String[] args) throws IOException {
		getUrl3();
		//regex();
	}
	public static void getUrl() throws IOException{
		java.net.URL url = new java.net.URL("http://61.191.22.157/tyfw/infoquery/hedaosec.aspx"); 
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		  //得到输入流，即获得了网页的内容 
		  BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection
		    .getInputStream()));
		  String line;
		  // 读取输入流的数据，并显示
		  while ((line = reader.readLine()) != null){
			  Pattern pattern = Pattern.compile("new\\s+Option\\(.*,");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					System.out.println(matcher.group());
				}  
		  }
	}
	public static void getUrl2() throws IOException{
		java.net.URL url = new java.net.URL("http://61.191.22.157/tyfw/infoquery/hedaosec.aspx"); 
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		  //得到输入流，即获得了网页的内容 
		  BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection
		    .getInputStream()));
		  String line;
		  // 读取输入流的数据，并显示
		  while ((line = reader.readLine()) != null){
			  Pattern pattern = Pattern.compile("new\\s+Option\\(.*,");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					String str = matcher.group();
					Matcher matcher2 = Pattern.compile("\"(.*)\"").matcher(str);
					while (matcher2.find()) {
						System.out.println(matcher2.group());
					}
				}  
		  }
	}
	public static void getUrl3() throws IOException{
		java.net.URL url = new java.net.URL("http://61.191.22.157/tyfw/infoquery/hedaosec.aspx"); 
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		  //得到输入流，即获得了网页的内容 
		  BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection
		    .getInputStream()));
		  String line;
		  // 读取输入流的数据，并显示
		  while ((line = reader.readLine()) != null){
			  Pattern pattern = Pattern.compile("new\\s+Option\\(\"(.*)\",");
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					System.out.println(matcher.group(1));
				}  
		  }
	}
	public  static void regex(){
		String str = "slt.options[slt.length]=new Option(蚌 埠 闸上,50103800);";
		Pattern pattern = Pattern.compile("Option\\((.*),[0-9]+\\)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}
