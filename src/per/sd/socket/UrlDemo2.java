package per.sd.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class UrlDemo2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.baidu.com/?tn=SE_hldp00512_huttpmkq");
		InputStream inputStream = url.openStream();
//		while (-1 != (length=inputStream.read(bytes))) {
//			String str = new String(bytes,0, (int) length);
//			System.err.println(str);
//		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
		String msg = null;
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"), "utf-8"));
		while (null != (msg=bufferedReader.readLine())) {
			bufferedWriter.append(msg);
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
		
	}
}
