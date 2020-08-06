package com.github.Yury1991.Authorization;



import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.io.NotSerializableException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

//Управление интерфейсом - index
public class IndexController extends SelectorComposer<Component> implements Serializable {	

	private static final long serialVersionUID = 6320224689482179454L;
	@Wire
	private Textbox login;
	@Wire 
	private Textbox password;


	@Wire
	private Button enterButton;

	@Wire
	private Button registerButton;
	
	@Listen("onClick = #enterButton")
	public void enter() throws SQLException, IOException {

		User user = new User(login.getValue(), password.getValue());		
		AccessData a = new AccessData();
		boolean search = a.check(user);		
		if(search == true ) {
			if(("admin" == Admin.admLogin) && ("admin" == Admin.admPassword)){	//				
				enterButton.setHref("admin.zul");			// user.getlogin() не подходит и login.getValue()
			}
			else {
				System.out.println();
				a.save(user);
				enterButton.setHref("user.zul");				
			}			
		}
		else {
			enterButton.setHref("error.zul");
		}
	}   
}	


