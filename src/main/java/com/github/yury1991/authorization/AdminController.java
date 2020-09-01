package com.github.yury1991.authorization;

import java.io.IOException;

import java.sql.SQLException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

//Управление интерфейсом - admin

public class AdminController extends SelectorComposer<Component> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	private Button showButton;

	@Wire
	private Button deleteButton;

	@Listen("onClick =  #showButton")
	public void showDb() throws SQLException, IOException {
		SqlDao sqlDao = new SqlDao();		
		sqlDao.show();
	}

	
}
