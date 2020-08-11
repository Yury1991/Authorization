package com.github.Yury1991.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

//Управление интерфейсом - registration
public class RegistrationController extends SelectorComposer<Component> {
	

	private static final long serialVersionUID = 6320224689482179454L;
	@Wire
	private Textbox newLogin;
	@Wire 
	private Textbox newPassword;
	
	@Wire
	private Button createButton;	
	@Wire
	private Button backButton;
	
	
	
	@Listen ("onClick = #createButton")
	public void create() throws SQLException, IOException {			
		User user = new User(newLogin.getValue(), newPassword.getValue());
		SqlDao sqlDao = new SqlDao();
		sqlDao.create(user);		
		createButton.setHref("user.zul");
				
	}
		
	
	
}	

