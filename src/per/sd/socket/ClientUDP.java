package per.sd.socket;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 服务器端接受数据
 * 
 * 
 * 1、创建客户端和端口
 * 2、创建容器并放入数据（byte 数组）
 * 3、打包数据(打包目标地址、端口和数据)
 * 4、发送数据
 * 5、释放资源
 * @author shallowdream
 *
 */
public class ClientUDP {
	public static void main(String[] args) throws IOException {
		
		DatagramSocket client = new DatagramSocket(8809);
	
		String msg = "何处繁华笙歌落";
		byte[] bytes = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(bytes, bytes.length,new InetSocketAddress("localhost", 8895));
		
		client.send(packet);
		
		client.close();
	}
	public byte[] convert(double num) throws IOException{
		return null;
	}
}
