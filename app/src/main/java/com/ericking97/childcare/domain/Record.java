package com.ericking97.childcare.domain;

import com.ericking97.childcare.domain.errors.NotEnoughElements;

public class Record {
	private Child child;
	private Tutor tutor;
	private String phone;
	private String emergencyPhone;
	private String address;

	@Override
	public String toString() {
		return String.format(
			"%s,%s,%s,%s,%s",
			child.toString(),
			phone,
			emergencyPhone,
			address,
			tutor.toString()
		);
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
}

}
