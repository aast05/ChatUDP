package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class SendUDP {

	public static void main(String args[]){
		try{
			InetAddress dst = InetAddress.getByName("224.0.0.1");
			byte array[];
			String msg = "Je fais un test";
			array = msg.getBytes();
			DatagramPacket p = new DatagramPacket(array,array.length,dst,7654);
			DatagramSocket s = new DatagramSocket();
			s.send(p);
			
			Thread.sleep(500);
			//System.out.println("sended");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
