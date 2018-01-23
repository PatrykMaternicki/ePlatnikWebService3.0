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
		super("ePlatnikService"); //tytu³ okna
		setLayout(new FlowLayout());           // ustalenie rozk³adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkniêcia okna
	    setVisible(true); //widocznoœæ okna
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
	
	//obs³uga zdarzeñ
	@Override
	public void actionPerformed(ActionEvent e) {
		
			dispose(); //zamknij bie¿¹ce okno
			new GUImodeSystem(); //otwórz nowe okno
	}
	
}
