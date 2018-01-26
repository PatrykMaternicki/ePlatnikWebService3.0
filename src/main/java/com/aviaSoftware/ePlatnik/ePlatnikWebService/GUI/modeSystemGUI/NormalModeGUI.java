package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.modeSystemGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.GUImodeSystem;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.WebRedirect.UserType;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.WebRedirect.WebRedirect;

public class NormalModeGUI extends JFrame implements ActionListener{
	private JLabel label;
	private JButton backButton;
	private JLabel labelRadio;
	
	private WebRedirect web;
	private JButton linkJbutton;
	private URI uri;
	
	private JRadioButton superAdministrator;
	private JRadioButton administrator;
	private JRadioButton menager;
	private JRadioButton employee;
	private JRadioButton presenter;
	private JRadioButton trainer;

	
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
		
		 //tworzenie listenera dla przycisków
	     backButton.addActionListener(this);
	     
	   //dodawanie etykiety i przycisków
	     add(label);
	     add(backButton);
	     
	     
	    //tworzenie radiobuttons
	     superAdministrator = new JRadioButton("SuperAdministrator");
	     superAdministrator.setMnemonic(KeyEvent.VK_S);
	     superAdministrator.setActionCommand("superAdministrator");

	     administrator = new JRadioButton("Administrator");
	     administrator.setMnemonic(KeyEvent.VK_A);
	     administrator.setActionCommand("administrator");

	     menager = new JRadioButton("Menager");
	     menager.setMnemonic(KeyEvent.VK_M);
	     menager.setActionCommand("menager");

	     employee = new JRadioButton("Employee");
	     employee.setMnemonic(KeyEvent.VK_E);
	     employee.setActionCommand("employee");

	     presenter = new JRadioButton("Presenter");
	     presenter.setMnemonic(KeyEvent.VK_P);
	     presenter.setActionCommand("presenter");
	     
	     trainer = new JRadioButton("Trainer");
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
	
	//przeci¹¿ony konstruktor
	public NormalModeGUI(JButton linkJbutton, WebRedirect web) {

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
		
		 //tworzenie listenera dla przycisków
	     backButton.addActionListener(this);
	     
	   //dodawanie etykiety i przycisków
	     add(label);
	     add(backButton);
	     
	     
	    //tworzenie radiobuttons
	     superAdministrator = new JRadioButton("SuperAdministrator");
	     superAdministrator.setMnemonic(KeyEvent.VK_S);
	     superAdministrator.setActionCommand("superAdministrator");
	     if(web.getURI().toString().equals("http://localhost:9090/superadministrator")) {
		     superAdministrator.setSelected(true);
		     }

	     administrator = new JRadioButton("Administrator");
	     administrator.setMnemonic(KeyEvent.VK_A);
	     administrator.setActionCommand("administrator");
	     if(web.getURI().toString().equals("http://localhost:9090/administrator")) {
		     administrator.setSelected(true);
		     }

	     menager = new JRadioButton("Menager");
	     menager.setMnemonic(KeyEvent.VK_M);
	     menager.setActionCommand("menager");
	     if(web.getURI().toString().equals("http://localhost:9090/menager")) {
		     menager.setSelected(true);
		     }

	     employee = new JRadioButton("Employee");
	     employee.setMnemonic(KeyEvent.VK_E);
	     employee.setActionCommand("employee");
	     if(web.getURI().toString().equals("http://localhost:9090/employee")) {
		     employee.setSelected(true);
		     }

	     presenter = new JRadioButton("Presenter");
	     presenter.setMnemonic(KeyEvent.VK_P);
	     presenter.setActionCommand("presenter");
	     if(web.getURI().toString().equals("http://localhost:9090/presenter")) {
		     presenter.setSelected(true);
		     }
	     
	     trainer = new JRadioButton("Trainer");
	     trainer.setMnemonic(KeyEvent.VK_T);
	     trainer.setActionCommand("trainer");
	     if(web.getURI().toString().equals("http://localhost:9090/trainer")) {
	    	 trainer.setSelected(true);
		     }

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
	     
	     //dodawanie dodatkowego przycisku
	     uri = web.getURI();
		 linkJbutton = web.getLinkButton(uri);
	     
	     this.linkJbutton = linkJbutton;
	     linkJbutton.addActionListener(this);
	     add(linkJbutton);
	}
	 
	//ustawienia okna
	private void frameSetup() {
		setLayout(new FlowLayout());           // ustalenie rozk³adu jego contentPane
		pack();           // spakowanie okna
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //opcje zamkniêcia okna
	    setVisible(true); //widocznoœæ okna
	    setSize(400,280);  //rozmiar okna
	    setLocationRelativeTo(null);  // centrowanie okna w obszarze pulpitu
	}
	
	
	
	   //obs³uga zdarzeñ
		@Override
		public void actionPerformed(ActionEvent e) {
			
			    //zdarzenie dla przycisku wstecz
				if(e.getSource().equals(backButton)) {
					dispose(); // zamknij okno
					new GUImodeSystem(); //otwórz nowe okno
				}
				
				//zdarzenia dla radio buttons wyboru rodzaju u¿ytkownika 
				if(e.getSource().equals(superAdministrator)) {
					web = new WebRedirect(UserType.SuperAdministrator);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				if(e.getSource().equals(administrator)) {
					web = new WebRedirect(UserType.Administrator);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				if(e.getSource().equals(menager)) {
					web = new WebRedirect(UserType.Menager);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				if(e.getSource().equals(employee)) {
					web = new WebRedirect(UserType.Employee);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				if(e.getSource().equals(presenter)) {
					web = new WebRedirect(UserType.Presenter);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				if(e.getSource().equals(trainer)) {
					web = new WebRedirect(UserType.Trainer);
					dispose();
					new NormalModeGUI(linkJbutton, web);
				}
				
				//zdarzenie dla otwarcia linku z adresem do web serwisu
				if(e.getSource().equals(linkJbutton)) {
			 		WebRedirect.open(uri);
			 	}
			
		}
}
