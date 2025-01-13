package com.ericking97.childcare.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.junit.Test;

import com.ericking97.childcare.domain.errors.NotEnoughElements;


public class ChildTest {
	
	@Test public void genderConvertion() {
		Child child = new Child();
		
		child.setGender(Gender.MASCULINE);
		assertSame("gender must be string", "Masculino", child.getGender());
		child.setGender(Gender.FEMENINE);
		assertSame("gender must be string", "Femenino", child.getGender());
		child.setGender(Gender.OTHER);
		assertSame("gender must be string", "Otro", child.getGender());
	}

	@Test public void correctlyExport() {
		Child child = new Child();
		child.setFirstname("José Erick");
		child.setFirstSurname("Sánchez");
		child.setSecondSurname("Muñoz");
		child.setGender(Gender.MASCULINE);
		child.setBirthdate(LocalDate.of(1997, Month.FEBRUARY, 10));

		assertEquals(
			"string repr must be the same", 
			"José Erick, Sánchez, Muñoz, Masculino, 1997-02-10", 
			child.toString()
		);
	}

	@Test public void correctlyImport() throws NotEnoughElements {
		String record = "José Erick, Sánchez, Muñoz, Masculino, 1997-02-10";
		Child child = new Child();
		child.fromString(record);

		assertEquals(
			"string import must be the same",
			child.toString(),
			record
		);
	}

	@Test public void notEnoughElements() {
		String record = "José Erick, Sánchez, Muñoz";
		Child child = new Child();
		NotEnoughElements e = assertThrows(
			"not enough elements to unpack", 
			NotEnoughElements.class, 
			() -> child.fromString(record)
		);
		assertEquals("Not enough elements to unpack", e.getMessage());
	}

	@Test public void invalidDate() {
		String record = "José Erick, Sánchez, Muñoz, Masculino, 19-02-10";
		Child child = new Child();
		assertThrows(
			"wrong format", 
			DateTimeParseException.class,
			() -> child.fromString(record)
		);
	}
}
