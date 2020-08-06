package com.github.Yury1991.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

//Управление интерфейсом - change

public class ChangeController extends SelectorComposer<Component>{
	
	@Wire
	private Textbox changePass;
	@Wire
	private Button confirmButton;

	@Listen("onCick = #confirmButton")
	public void changePass() throws ClassNotFoundException, IOException, SQLException {
		AccessData a = new AccessData();
		User user = a.load();
		user.setPassword(changePass.getValue());
		a.change(user);
	}


}
