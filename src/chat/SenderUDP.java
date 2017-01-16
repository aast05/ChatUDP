package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class SenderUDP{
	private String address; private int port;private DatagramSocket socket;private InetAddress inetAddr;private String msg;
	public static SenderUDP Instance = new SenderUDP();
	
	private SenderUDP() {}
	
	/**
	 * Initialize the SenderUDP with address and port
	 * @param address
	 * @param port
	 */
	public void init(String address,int port){
		this.address = address; this.port = port;
		try{
			this.inetAddr = InetAddress.getByName(this.address);
			this.socket = new DatagramSocket();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Run the process to send a Message
	 * @param message the message to send
	 */
	public void run(String message){
		try {
			byte buffer[];
			/* le nom de l'expediteur + un separateur + le message */
			buffer = (Main.userName +Main.nameSeparator+ message).getBytes();
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length,this.inetAddr,this.port);
			socket.send(packet);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
}
