package com.ericking97.childcare.domain;

import com.ericking97.childcare.domain.errors.NotEnoughElements;

public interface TextParser {
	public void fromString(String t) throws NotEnoughElements;
}
