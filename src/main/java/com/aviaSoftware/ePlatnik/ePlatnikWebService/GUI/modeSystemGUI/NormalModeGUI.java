package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.GUImodeSystem;

public class NormalModeGUI extends JFrame implements ActionListener{
	private JLabel label;
	private JButton backButton;
	private JLabel labelRadio;
	
	public NormalModeGUI() {
		
		super("ePlatnikService"); //tytu³ okna
		
		frameSetup(); //ustawienia okna
		
		//tworzenie etykiety
		label = new JLabel();
		label.setText("Tryb pracy: Normal");
		label.setFont(new Font("Label", Font.BOLD, 26));
		label.setForeground(Color.DARK_GRAY);
		
		 // tworzenie przycisków
		backButton = new JButton("<--- wstecz <---");
		backButton.setFont( new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		backButton.setForeground(Color.BLUE);
		
		 //tworzenie listenera na przycisków
	     backButton.addActionListener(this);
	     
	   //dodawanie etykiety i przycisków
	     add(label);
	     add(backButton);
	     
	     
	    //tworzenie radiobuttons
	     JRadioButton superAdministrator = new JRadioButton("SuperAdministrator");
	     superAdministrator.setMnemonic(KeyEvent.VK_S);
	     superAdministrator.setActionCommand("superAdministrator");
	     superAdministrator.setSelected(true);

	     JRadioButton administrator = new JRadioButton("Administrator");
	     administrator.setMnemonic(KeyEvent.VK_A);
	     administrator.setActionCommand("administrator");

	     JRadioButton menager = new JRadioButton("Menager");
	     menager.setMnemonic(KeyEvent.VK_M);
	     menager.setActionCommand("menager");

	     JRadioButton employee = new JRadioButton("Employee");
	     employee.setMnemonic(KeyEvent.VK_E);
	     employee.setActionCommand("employee");

	     JRadioButton presenter = new JRadioButton("Presenter");
	     presenter.setMnemonic(KeyEvent.VK_P);
	     presenter.setActionCommand("presenter");
	     
	     JRadioButton trainer = new JRadioButton("Trainer");
	     trainer.setMnemonic(KeyEvent.VK_T);
	     trainer.setActionCommand("trainer");

	   //tworzenie etykiety
			labelRadio = new JLabel();
			labelRadio.setText("Wybierz rodzaj u¿ytkownika");
			labelRadio.setFont(new Font("Label", Font.BOLD, 20));
			labelRadio.setForeground(Color.BLUE);
	     
	     //Group the radio buttons.
	     ButtonGroup group = new ButtonGroup();
	     group.add(superAdministrator);
	     group.add(administrator);
	     group.add(menager);
	     group.add(employee);
	     group.add(presenter);
	     group.add(trainer);

	     //Register a listener for the radio buttons.
	     superAdministrator.addActionListener(this);
	     administrator.addActionListener(this);
	     menager.addActionListener(this);
	     employee.addActionListener(this);
	     presenter.addActionListener(this);
	     trainer.addActionListener(this);
	     
	     //add label and radiobuttons to container
	     add(labelRadio);
	     add(superAdministrator);
	     add(administrator);
	     add(menager);
	     add(employee);
	     add(presenter);
	     add(trainer);

	    
	}
	
	private void frameSetup() {
		setLayout(new FlowLayout());           // ustalenie rozk³adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkniêcia okna
	    setVisible(true); //widocznoœæ okna
	    setSize(400,250);  //rozmiar okna
	    setLocationRelativeTo(null);  // centrowanie okna w obszarze pulpitu
	}
	
	   //obs³uga zdarzeñ
		@Override
		public void actionPerformed(ActionEvent e) {
			
				
				
				if(e.getSource().equals(backButton)) {
					dispose(); // zamknij okno
					new GUImodeSystem(); //otwórz nowe okno
				}
			
		}
}
