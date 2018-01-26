package com.aviaSoftware.ePlatnik.ePlatnikWebService.GUI.WebRedirect;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class WebRedirect {
	
    private URI uri;
    private UserType userType;
    
    
    public WebRedirect(UserType userType) {
    	this.uri = getURI(userType);
    	this.userType = userType;
    }
    
    private URI getURI(UserType userType) {
    	switch(userType) {
    	case SuperAdministrator :  
    			try {
    			uri = new URI("http://localhost:9090/superadministrator"); 
    			} catch(URISyntaxException exc) {
    				exc.printStackTrace();
    			};
    			break;
    	case Administrator :  
			try {
			uri = new URI("http://localhost:9090/administrator"); 
			} catch(URISyntaxException exc) {
				exc.printStackTrace();
			};
			break;
    	case Menager :  
			try {
			uri = new URI("http://localhost:9090/menager"); 
			} catch(URISyntaxException exc) {
				exc.printStackTrace();
			};
			break;
    	case Employee :  
			try {
			uri = new URI("http://localhost:9090/employee"); 
			} catch(URISyntaxException exc) {
				exc.printStackTrace();
			};
			break;
    	case Presenter :  
			try {
			uri = new URI("http://localhost:9090/presenter"); 
			} catch(URISyntaxException exc) {
				exc.printStackTrace();
			};
			break;
    	case Trainer :  
			try {
			uri = new URI("http://localhost:9090/trainer"); 
			} catch(URISyntaxException exc) {
				exc.printStackTrace();
			};
			break;
    	default : 
    		try {
    			uri = new URI("http://localhost:9090"); 
    			} catch(URISyntaxException exc) {
    				exc.printStackTrace();
    			};
    			break;
    	}
    	return uri;
    }
    
    public static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
          try {
            Desktop.getDesktop().browse(uri);
          } catch (IOException exc) { 
        	  exc.printStackTrace();
          }
        }	  
    }
    
  //tworzenie przycisku z linkiem
  	public JButton getLinkButton(URI uri) {
  	     JButton link = new JButton();
  	     link.setText("<HTML><FONT color=\\\"#000099\\\">Kliknij w ten obszar"
  	    	        + " aby uruchomiæ serwis webowy <U>ePlatnik</U></FONT><br />"
  	    	        +" <center>jako u¿ytkownik " + userType.toString() +"</center></HTML>");
  	     link.setHorizontalAlignment(SwingConstants.LEFT);
  	     link.setBorderPainted(true);
  	     link.setOpaque(false);
  	     link.setBackground(Color.WHITE);
  	     link.setToolTipText(uri.toString());
  	     return link;
  	}
  	
  	public URI getURI() {
  		return uri;
  	}
}