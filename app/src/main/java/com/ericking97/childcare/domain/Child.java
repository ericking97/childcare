package com.ericking97.childcare.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import com.ericking97.childcare.domain.errors.NotEnoughElements;

public class Child extends Entity implements TextParser {

	private Gender gender;
	private LocalDate birthdate;

	@Override
	public void fromString(String t) throws NotEnoughElements {
		String[] columns = t.split(",");
		if (columns.length != 5) {
			throw new NotEnoughElements("Not enough elements to unpack");
		}

		String firstname = columns[0].trim();
		String firstSurname = columns[1].trim();
		String secondSurname = columns[2].trim();
		String genderStr = columns[3].trim();
		String birthdateStr = columns[4].trim();

		Gender gender;
		switch (genderStr) {
			case "Masculino":
				gender = Gender.MASCULINE;
				break;
			case "Femenino":
				gender = Gender.FEMENINE;
				break;
			default:
				gender = Gender.OTHER;
				break;
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ld = LocalDate.parse(birthdateStr, dtf);

		this.setFirstname(firstname);
		this.setFirstSurname(firstSurname);
		this.setSecondSurname(secondSurname);
		this.setGender(gender);
		this.setBirthdate(ld);
	}

	@Override
	public String toString() {
		return String.format(
			"%s, %s, %s, %s, %s", 
			this.getFirstname(),
			this.getFirstSurname(),
			this.getSecondSurname(),
			this.getGender(),
			birthdate
		);
	}

	public String getGender() {
		String gender;
		switch (this.gender) {
			case MASCULINE:
				gender = "Masculino";
				break;
			case FEMENINE:
				gender = "Femenino";
				break;
			default:
				gender = "Otro";
				break;
		}
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

}
