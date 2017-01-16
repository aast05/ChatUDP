package chat.display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Synthesizer;
import javax.swing.JTextField;

import chat.SenderUDP;

public class SendController implements ActionListener{
	private JTextField toSend;
	public SendController(JTextField field){
		this.toSend=field;
	}
	public void actionPerformed(ActionEvent arg0) {// cette methode est lancé lorsque l'on appui sur le bouton Send de l'interface graphique
		if(!this.toSend.getText().equals("")){// un paquet va etre envoyé uniquement si le contenu du message n'est pas vide
			SenderUDP.Instance.run(this.toSend.getText());
			this.toSend.setText("");
		}
	}
	
}
