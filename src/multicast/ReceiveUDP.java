package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.sound.midi.Synthesizer;
public class ReceiveUDP {
	public static void main(String args[]){
		DatagramPacket p ;
		try{
			MulticastSocket s = new MulticastSocket(7654);
			s.joinGroup(InetAddress.getByName("224.0.0.1"));
			byte buffer[] = new byte[255];
			while(true){
				p = new DatagramPacket(buffer,buffer.length);
				s.receive(p);
				System.out.println("from :"+p.getAddress()+" port :"+p.getPort()+" size :"+p.getLength());
				System.out.println(new String(buffer,0,buffer.length));
				System.out.println("received");
			}
			//s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
