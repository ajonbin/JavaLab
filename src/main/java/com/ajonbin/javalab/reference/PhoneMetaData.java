package com.ajonbin.javalab.reference;

import java.util.Date;

public class PhoneMetaData {
	private Date createDate;

	public PhoneMetaData(){
		createDate = new Date();
	}

	@Override
	public String toString() {
		return new String("Phone Create on " + createDate.toString());
	}


}
