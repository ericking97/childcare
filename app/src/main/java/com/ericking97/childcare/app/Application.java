package com.ericking97.childcare.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ericking97.childcare.domain.Child;
import com.ericking97.childcare.domain.errors.NotEnoughElements;

public class Application {
	public static void main(String[] args) {
		String record = "José Erick, Sánchez, Muñoz, Masculino, 19-02-10";
		Child child = new Child();
		try {
			child.fromString(record);
		} catch (NotEnoughElements e) {
			// TODO: handle exception
		}
		System.out.println(child);
	}
}
