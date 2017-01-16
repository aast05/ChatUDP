package chat.display;

import java.net.DatagramPacket;

import javax.swing.SwingUtilities;

import chat.Main;

public class ReceiveMessageController {
	public static void newPacket(DatagramPacket packet){// cette methode va etre lancé lors de l'arrivé d'un message
		String packContent,from,ip,msg;
		packContent = new String(packet.getData(),0,packet.getLength());
		/* premiere partie le nom de l'expediteur */
		from = packContent.split(Main.nameSeparator)[0];
		// puis le contenu du message envoyé 
		msg = packContent.split(Main.nameSeparator)[1];
		// on recupere l'IP
		ip = packet.getAddress().toString();
		// on demande a l'interface d'afficher le message sous ce format : 
		Main.disp.addReceivedMessage("("+ip+")"+from+" : "+msg);	
	}
}