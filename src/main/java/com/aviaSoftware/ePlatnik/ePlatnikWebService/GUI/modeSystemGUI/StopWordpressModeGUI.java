package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.GUImodeSystem;

public class StopWordpressModeGUI extends JFrame implements ActionListener{
	private JLabel label;
	private JButton backButton;
	
	public StopWordpressModeGUI() {
		
		super("ePlatnikService"); //tytu³ okna
		
		frameSetup(); //ustawienia okna
		
		//tworzenie etykiety
		label = new JLabel();
		label.setText("Tryb pracy: Stop Wordpress");
		label.setFont(new Font("Label", Font.BOLD, 26));
		label.setForeground(Color.DARK_GRAY);
		
		 // tworzenie przyciskuów
		backButton = new JButton("<--- wstecz <---");
		backButton.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		backButton.setForeground(Color.BLUE);
		
		 //tworzenie listenera na przycisków
	     backButton.addActionListener(this);
	     
	   //dodawanie etykiety i przycisków
	     add(label);
	     add(backButton);
	}
	
	private void frameSetup() {
		setLayout(new FlowLayout());           // ustalenie rozk³adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkniêcia okna
	    setVisible(true); //widocznoœæ okna
	    setSize(500,200);  //rozmiar okna
	    setLocationRelativeTo(null);  // centrowanie okna w obszarze pulpitu
	}
	
	   //obs³uga zdarzeñ
		@Override
		public void actionPerformed(ActionEvent e) {
			
				dispose(); // zamknij okno
				
				if(e.getSource().equals(backButton)) {
					new GUImodeSystem(); //otwórz nowe okno
				}
			
		}
}
