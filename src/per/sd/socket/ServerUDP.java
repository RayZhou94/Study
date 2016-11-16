package per.sd.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//模拟udp协议发送数据
/**
 * 1、创建服务器和端口号
 * 2、创建容器以接受数据(byte 数组)
 * 3、将容器分装成包
 * 4、分析数据
 * 5、释放资源
 * @author shallowdream
 *
 */
public class ServerUDP {
	public static void main(String[] args) throws IOException {
		DatagramSocket server = new DatagramSocket(8895);
		
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
		
		server.receive(packet);
		
		byte[] data = packet.getData();
		
		System.out.println(new String(data,0,data.length));
		server.close();
	}
}
