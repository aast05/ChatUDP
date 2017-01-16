package unicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
public class ReceiveUDP {
	public static void main(String args[]){
		try{
			int port = 8887;
			DatagramSocket s = new DatagramSocket(port);
				DatagramPacket p = new DatagramPacket(new byte[256],256);
				s.receive(p);
				System.out.println("from :"+p.getAddress()+" port :"+p.getPort()+" size :"+p.getLength());
				byte array[] = p.getData();
				System.out.println(new String(array,0,array.length));
				System.out.println("received");
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
