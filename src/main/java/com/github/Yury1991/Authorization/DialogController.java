package com.github.Yury1991.Authorization;

import java.io.IOException;
import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

public class DialogController extends SelectorComposer<Component>{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	 private Button yesButton;
	 
	
	@Listen("onClick = #yesButton")
	 public void userDelete() throws SQLException, IOException {
		 SqlDao sqlDao = new SqlDao();		
		 User user = (User)Subject.subjects.get(0);		 
		 sqlDao.delete(user);
		 yesButton.setHref("successDelete.zul");
		 Subject.subjects.clear();	
	 }
	 
	 
}
