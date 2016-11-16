package per.sd.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			while (true) {
				Socket socket =	server.accept();
				
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				System.err.println(dis.readUTF());
				
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String msg = "服务器----》";
				dos.writeUTF(msg);
				dos.flush();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
