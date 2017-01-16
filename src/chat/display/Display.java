package chat.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.util.concurrent.locks.Lock;
import chat.Main;

public class Display extends JFrame{
	private JPanel container = new JPanel();
	private JTextField sendMessageTextArea = new JTextField();
	private JButton sendButton = new JButton("Send");
	private JPanel receivePanel = new JPanel();
	public Display(String name){
		super(name);
		this.setSize(500,500);
		JScrollPane scroll = new JScrollPane();
		//scroll.add(container);
		this.setContentPane(container);container.setLayout(new BorderLayout());
		this.createSendInput();
		this.createReceiveArea();
		this.sendButton.addActionListener(new SendController(this.sendMessageTextArea));
		this.setVisible(true);
		this.askForName();
		this.setTitle(this.getTitle()+"("+Main.userName+")");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/*** CREATION'S METHODS ***/
	public void createReceiveArea(){
		JScrollPane scroll = new JScrollPane(this.receivePanel);
		JPanel panel = this.receivePanel;
		BoxLayout panLay = new BoxLayout(panel,BoxLayout.PAGE_AXIS);
		panel.setLayout(panLay) ; panel.setBackground(Color.yellow);
		this.container.add(scroll,BorderLayout.CENTER);
		this.validate();this.repaint();
	}
	public void createSendInput(){
		JPanel panel = new JPanel();panel.setLayout(new BorderLayout());
		panel.add(this.sendMessageTextArea,BorderLayout.CENTER);panel.add(this.sendButton,BorderLayout.EAST);
		this.container.add(panel,BorderLayout.SOUTH);
	}
	public void askForName(){
		JButton sendButton1 = new JButton("send");JTextField textField = new JTextField();
		JDialog dialog =new JDialog(this,"Your Name",true);
		sendButton1.addActionListener(new SendNameListener(textField,dialog));
		dialog.setSize(150, 150);
		dialog.getContentPane().add(textField,BorderLayout.CENTER);
		dialog.getContentPane().add(sendButton1,BorderLayout.SOUTH);
		dialog.setVisible(true);
		
	}
	/*** MODIFICATION'S METHODS ***/
	public void addReceivedMessage(String msg){
		JPanel panel = this.receivePanel;
		panel.add(new JLabel(msg));
		panel.validate();panel.repaint();
	}
/********/
	private class SendNameListener implements ActionListener{
		private JTextField textField;private JDialog dialog;
		public SendNameListener(JTextField field,JDialog dialog){this.textField = field;this.dialog=dialog;}
		public void actionPerformed(ActionEvent arg0) {
			if(!this.textField.getText().equals(""))
				Main.userName = this.textField.getText();
			this.dialog.setVisible(false);	
			
		}
		
	}
}
