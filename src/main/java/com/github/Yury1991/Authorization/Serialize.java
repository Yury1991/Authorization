package com.github.Yury1991.Authorization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	
	private  static final String SERIAL_PATH = "D:\\Programming\\eclipse-workspace\\Authorization\\src\\main\\resources\\user.ser";
	//---------------------Сериализация---------------------------------

	// 1. Сохранение данных пользователя, для будущих операций над ними
	public void save(User user) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(SERIAL_PATH);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.close();
	}
	// 2. Загрузка данных пользователя
	public User load() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(SERIAL_PATH);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {				 
			return ((User) objectInputStream.readObject());
		}		     
	}
	// 3. Очистка файла сериализации
	public void clean() { // файл сериализации должен очищаться после каждой загрузки

	}

	
}

