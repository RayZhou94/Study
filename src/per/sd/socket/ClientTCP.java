package per.sd.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 9999);
			String msg = "客户端。。。";
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(msg);
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
