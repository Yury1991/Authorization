package com.github.yury1991.authorization;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Кнопка changePass - изменение пароля пользователя*/
	@Wire
	private Textbox changePass;
	/** Кнопка ConfirmButton - изменение пароля пользователя*/
	@Wire
	private Button confirmButton;

	/** Обработка нажатия на кнопку*/
	@Listen("onClick = #confirmButton")
	public void changePassword() throws ClassNotFoundException, IOException, SQLException {	
		System.out.println("Confirm button pressed!");
		if(!Subject.subjects.isEmpty()) {
			SqlDao sqlDao = new SqlDao(); 
			User user = (User)Subject.subjects.get(0);	
			user.setPassword(changePass.getValue());
			sqlDao.change(user);
			confirmButton.setHref("successChange.zul");
			Subject.subjects.clear();
			
		}
		else {
			System.out.println("AccessData is empty!");
		}		
	}
}
