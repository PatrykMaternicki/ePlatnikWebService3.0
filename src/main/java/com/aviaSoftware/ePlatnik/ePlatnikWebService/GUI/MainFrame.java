package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton b;
	
	public MainFrame() {
		//ustawienia okna
		super("ePlatnikService"); //tytu� okna
		setLayout(new FlowLayout());           // ustalenie rozk�adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkni�cia okna
	    setVisible(true); //widoczno�� okna
	    setSize(500,200);  //rozmiar okna
	    setLocationRelativeTo(null);  // centrowanie okna w obszarze pulpitu
	    
	    // tworzenie przycisku
	     b = new JButton("uruchom serwis");
	     b.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     b.setForeground(Color.blue);
	     
	     //tworzenie listenera na przycisku
	     b.addActionListener(this);
	     
	     //dodawanie przycisku
	    add(b);
	}
	
	//obs�uga zdarze�
	@Override
	public void actionPerformed(ActionEvent e) {
		
			dispose(); //zamknij bie��ce okno
			new GUImodeSystem(); //otw�rz nowe okno
	}
	
}
