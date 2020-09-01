package com.github.yury1991.authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

public class AdminDeleteController extends SelectorComposer<Component> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private Textbox deleteAccount;
	@Wire
	private Button deleteButton;

	@Listen("onClick = #deleteButton")
	public void deleteAccount() throws ClassNotFoundException, IOException, SQLException {	
		System.out.println("Delete button pressed!");
		if(!Subject.subjects.isEmpty()) {
			SqlDao sqlDao = new SqlDao();			 
			User user = new User(deleteAccount.getValue(),"empty" );			
			sqlDao.delete(user);
			Subject.subjects.clear();			
		}
		else {
			System.out.println("AccessData is empty!");
		}
	}
}
