package com.ericking97.childcare.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TutorTest {
	
	@Test public void correctlyExport() {
		Tutor tutor = new Tutor();
		tutor.setFirstname("Cosme");
		tutor.setFirstSurname("Fulanito");
		tutor.setSecondSurname("Miguelito");

		assertEquals(
			"string repr must be the same", 
			"Cosme,Fulanito,Miguelito", 
			tutor.toString()
		);
	}

}
