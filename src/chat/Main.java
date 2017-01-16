package chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import chat.display.Display;

public class Main {
	/* ATTRIBUTES */
	public static Display disp;
	public static String userName = "noname";
	public static final String nameSeparator=":";
	
	public static void main(String args[]){
		Main.startChat("224.0.0.1", 7654);
	}
	public static void startChat(String multicastAddress,int port){
		// on initialise la classe qui va envoyer les messages
		SenderUDP.Instance.init(multicastAddress,port);
		// on cree le Thread qui va s'occuper de la reception des messages
		ReceiverUDP receiver = new ReceiverUDP(multicastAddress,port);
		try{
			// on lance ce Thread pour la reception des messages
			receiver.start();
			// on lance l'interface graphique
			Main.disp = new Display("UDP Multicasting");
			receiver.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
