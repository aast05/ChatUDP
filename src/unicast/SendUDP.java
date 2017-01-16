package unicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class SendUDP {

	public static void main(String args[]){
		try{
			int port = 8887;
			InetAddress dst = InetAddress.getByName("127.0.0.1");
			byte array[];
			String msg = "On se calme";
			array = msg.getBytes();
			DatagramPacket p = new DatagramPacket(array,array.length,dst,port);
			p.setData(array);
			DatagramSocket s = new DatagramSocket();
			s.send(p);
			s.close();
			System.out.println("sended");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
