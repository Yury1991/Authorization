package com.github.yury1991.authorization;



import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
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
		SqlDao sqlDao =  new SqlDao();
		boolean search = sqlDao.check(user);			
		if(search == true ) {
			if((user.getLogin() == Admin.getInstance().getLogin()) && (user.getPassword() == Admin.getInstance().getPassword())){				
				enterButton.setHref("admin.zul");			
			}
			else {
				System.out.println();				
				enterButton.setHref("user.zul");				
			}			
		}
		else {
			enterButton.setHref("error.zul");
		}
	}   
}	


