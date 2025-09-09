import javax.swing.*;
import java.awt.Color;
import javax.swing.text.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Person1 implements ActionListener, Runnable {
	JTextPane textarea;
	StyledDocument doc;
	JTextField text;
	JButton send;
	Socket socket;
	ServerSocket server;
	Thread t1;
	DataOutputStream ds;
	DataInputStream din;

	Person1() {
		JFrame frame = new JFrame("Person1 (Server)");
		textarea = new JTextPane();
		textarea.setEditable(false); // User can’t type in textarea
		doc = textarea.getStyledDocument();
		
		textarea.setBounds(0, 0, 500, 300);
		text = new JTextField();
		text.setBounds(5, 300, 390, 50);
		send = new JButton("Send");
		send.setBounds(395, 300, 90, 50);
		send.addActionListener(this);
		frame.add(textarea);
		frame.add(text);
		frame.add(send);
		t1 = new Thread(this);
		t1.start();

		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}
	public void appendMessage(String msg, java.awt.Color c) {
	    try {
	        Style style = textarea.addStyle("Style", null);   // create a new style
	        StyleConstants.setForeground(style, c);           // set text color
	        doc.insertString(doc.getLength(), msg + "\n", style); // insert at the end
	    } catch (BadLocationException e) {
	        e.printStackTrace();
	    }
	}

	public void actionPerformed(ActionEvent e) {
		try {
			String msg = text.getText();
			ds.writeUTF(msg);
			ds.flush();
			appendMessage("Me: " + msg, Color.BLUE);
			text.setText("");
		} catch (Exception err) {
			System.out.println(err);
		}

	}

	public void run() {
		try {
			server = new ServerSocket(1818);
			appendMessage("Server started... waiting for client...", Color.GRAY);
			socket = server.accept();
			appendMessage("Client connected!", Color.GREEN);

			ds = new DataOutputStream(socket.getOutputStream());
			din = new DataInputStream(socket.getInputStream());
			while (true) {

				String msg = din.readUTF();
				appendMessage("Person2: " + msg, Color.MAGENTA);

			}
		} catch (Exception err) {
			System.out.println(err);
		}

	}

	public static void main(String[] args) {
		new Person1();
	}
}
