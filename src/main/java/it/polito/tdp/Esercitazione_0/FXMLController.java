package it.polito.tdp.Esercitazione_0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtuser"
    private TextField txtuser; // TESTO USERNAME

    @FXML // fx:id="txtpassword"
    private TextField txtpassword; // TESTO PASSWORD

    @FXML // fx:id="btnaccedi"
    private Button btnaccedi; // BOTTONE ACCEDI

    @FXML // fx:id="txtrisultato"
    private Label txtrisultato; // RISULTATO DI RITORNO

    @FXML // fx:id="txttentativi"
    private TextField txttentativi; // TESTO NUMERO DI TENTATIVI RIMASTI

    @FXML // fx:id="btnclear"
    private Button btnclear; // BOTTONE CLEAR

    
    public boolean checkPassword(String password){
		   String passwordPattern = "((?=.*\\d)(?=.*[A-Z])(?=.*[!?@#]).{6,200000})";
		   java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(passwordPattern);
		   java.util.regex.Matcher matcher = pattern.matcher(password);
		   return matcher.matches();
		}
    
    int tentativi = 3; 
    boolean corretto = false;
    boolean stop = false;
    
    @FXML
    void doAccedi(ActionEvent event) 
    {
    	String username = txtuser.getText();
    	String password = txtpassword.getText();
    	this.txttentativi.setText(""+this.tentativi);
    	
    	if(stop == false)
    	{
	    	if(!username.isEmpty() && !password.isEmpty())
	    	{
	    		this.tentativi--;
	    		if(this.tentativi == -1)
	    		{
	    			this.txtuser.setDisable(true);
	    			this.txtpassword.setDisable(true);
	    			txtrisultato.setText("TENTATIVI ESAURITI");
	    			this.txttentativi.setText(""+this.tentativi);
	    			stop = true;
	    			return;
	    			
	    		}
		    	if(this.tentativi > 0)
		    	{
		    		this.txttentativi.setText(""+this.tentativi);
		    		this.txtuser.setDisable(true);
		        	if(this.checkPassword(password))
		        	{
		        		this.txtuser.setDisable(true);
		    			this.txtpassword.setDisable(true);
		        		txtrisultato.setText("USERNAME E PASSWORD CORRETTO");
		        		stop = true;
		        	}
		        	else
		        	{
		        		txtrisultato.setText("USERNAME E PASSWORD NON CORRETTI");
		        		return;
		        	}
		    	} else
		    	{
		    		txtrisultato.setText("TENTATIVI ESAURITI");
		    		this.txtuser.setDisable(true);
	    			this.txtpassword.setDisable(true);
	    			stop=true;
		    		
		    	}
		    	if(this.tentativi == 0)
		    	{
		    		this.txttentativi.setText(""+this.tentativi);
		    		this.txtuser.setDisable(true);
		        	if(this.checkPassword(password))
		        	{
		        		this.txtuser.setDisable(true);
		    			this.txtpassword.setDisable(true);
		        		txtrisultato.setText("USERNAME E PASSWORD CORRETTO");
		        		stop = true;
		        	}
		        	else
		        	{
		        		txtrisultato.setText("USERNAME E PASSWORD NON CORRETTI: TENTATIVI ESAURITI! ");
		        		return;
		        	}
		    	} else
		    	{
		    		txtrisultato.setText("TENTATIVI ESAURITI");
		    		this.txtuser.setDisable(true);
	    			this.txtpassword.setDisable(true);
	    			stop=true;
		    		
		    	}
	    	} else 
		    	{
		    		txtrisultato.setText("CAMPO USERNAME E/O PASSWORD VUOTI");
		    		return;
		    	}
    	}
    }

    @FXML
    void doClear(ActionEvent event) 
    {
    	this.tentativi = 3;
    	stop = false;
    	this.txtuser.setDisable(false);
		this.txtpassword.setDisable(false);
		this.txttentativi.setText(""+this.tentativi);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtuser != null : "fx:id=\"txtuser\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtpassword != null : "fx:id=\"txtpassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnaccedi != null : "fx:id=\"btnaccedi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrisultato != null : "fx:id=\"txtrisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttentativi != null : "fx:id=\"txttentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
