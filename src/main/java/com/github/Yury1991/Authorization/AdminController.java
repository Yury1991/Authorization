package com.github.Yury1991.Authorization;

import java.io.IOException;

import java.sql.SQLException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

//Управление интерфейсом - admin

public class AdminController extends SelectorComposer<Component> {
	@Wire
	private Button showButton;

	@Wire
	private Button deleteButton;

	@Listen("onClick =  #showButton")
	public void showDb() throws SQLException, IOException {
		AccessData a = new AccessData();
		a.show();
	}

	@Listen("onClick = #deleteButton")
	public void delete() {
		AccessData a = new AccessData();

	}
}
