package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI.ConfigModeGUI;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI.DevelopmentModeGUI;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI.NormalModeGUI;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI.StandbyModeGUI;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI.StopWordpressModeGUI;

public class GUImodeSystem extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//pola przycisk�w
	private JButton config;
	private JButton development;
	private JButton normal;
	private JButton standby;
	private JButton stopWordpress;
	
	private JLabel label;
	
	
	//ustawienia okna
	public GUImodeSystem() {
		super("ePlatnikService"); //tytu� okna
		
		frameSetup(); //ustawienia okna
		
		//tworzenie etykiety
		label = new JLabel();
		label.setText("Wybierz tryb pracy systemu");
		label.setFont(new Font("Label", Font.BOLD, 26));
		label.setForeground(Color.DARK_GRAY);
	
		
	    // tworzenie przycisk�w
	     config = new JButton("Config mode");
	     config.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     config.setForeground(Color.blue);
	     
	     development = new JButton("Development mode");
	     development.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     development.setForeground(Color.blue);
	     
	     normal = new JButton("Normal mode");
	     normal.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     normal.setForeground(Color.blue);
	     
	     standby = new JButton("Standby mode");
	     standby.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     standby.setForeground(Color.blue);
	     
	     stopWordpress = new JButton("Stop Wordpress mode");
	     stopWordpress.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
	     stopWordpress.setForeground(Color.blue);
	     
	     //tworzenie listenera na przycisk�w
	     config.addActionListener(this);
	     development.addActionListener(this);
	     normal.addActionListener(this);
	     standby.addActionListener(this);
	     stopWordpress.addActionListener(this);
	     
	     //dodawanie etykiety i przycisk�w
	     add(label);
	     add(config);
	     add(development);
	     add(normal);
	     add(standby);
	     add(stopWordpress);
	}
	
	//ustawienia okna
	private void frameSetup() {
		setLayout(new FlowLayout());           // ustalenie rozk�adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkni�cia okna
	    setVisible(true); //widoczno�� okna
	    setSize(500,200);  //rozmiar okna
	    setLocationRelativeTo(null);  // centrowanie okna w obszarze pulpitu
	}
	
	//obs�uga zdarze�
	@Override
	public void actionPerformed(ActionEvent e) {
		
			dispose(); // zamknij okno
			
			if(e.getSource().equals(config)) {
				new ConfigModeGUI(); //otw�rz nowe okno
			}
			if(e.getSource().equals(development)) {
				new DevelopmentModeGUI(); //otw�rz nowe okno
			}
			if(e.getSource().equals(normal)) {
				new NormalModeGUI(); //otw�rz nowe okno
			}
			if(e.getSource().equals(standby)) {
				new StandbyModeGUI(); //otw�rz nowe okno
			}
			if(e.getSource().equals(stopWordpress)) {
				new StopWordpressModeGUI(); //otw�rz nowe okno
			}
		
	}
}
