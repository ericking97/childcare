package com.ericking97.childcare.domain;

import com.ericking97.childcare.domain.errors.NotEnoughElements;

public class Tutor extends Entity implements TextParser {

	@Override
	public void fromString(String t) throws NotEnoughElements {
		String[] data = t.split(",");
		if (data.length != 3) {
			throw new NotEnoughElements("Not enough elements to unpack");
		}

		String firstname = data[0].trim();
		String firstSurname = data[1].trim();
		String secondSurname = data[2].trim();

		setFirstname(firstname);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
	}

	@Override
	public String toString() {
		return String.format(
			"%s,%s,%s",
			getFirstname(),
			getFirstSurname(),
			getSecondSurname()
		);
	}

}
