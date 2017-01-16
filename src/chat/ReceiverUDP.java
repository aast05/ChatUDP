package chat;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import chat.display.Display;
import chat.display.ReceiveMessageController;

public class ReceiverUDP extends Thread {
	private String address; private int port;
	public ReceiverUDP(String address, int port){
		this.address = address; this.port = port;

	}

	public void run(){
		try{
			DatagramPacket packetRecu;
			// On ouvre le socket multicast avec le port precedemment initialisé par la classe Main
			MulticastSocket socket = new MulticastSocket(this.port);
			// Rejoins le groupe a l'adresse defini
			socket.joinGroup(InetAddress.getByName(this.address));
			byte buffer[] = new byte[255];String tmp;int cpt=0;
			while(true){// de maniere continue se met a l'attente d'un message
				packetRecu = new DatagramPacket(buffer,buffer.length);
				socket.receive(packetRecu);
				tmp = new String(buffer,0,buffer.length);
				ReceiveMessageController.newPacket(packetRecu);
				buffer=new byte[255];
			}
			
		}catch(Exception e){
			
		}
	}
}
