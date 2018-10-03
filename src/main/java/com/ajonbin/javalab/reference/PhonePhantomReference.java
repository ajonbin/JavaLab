package com.ajonbin.javalab.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhonePhantomReference extends PhantomReference<Phone> {

	private PhoneCleaner phoneCleaner;

	public PhonePhantomReference(Phone referent, PhoneCleaner phoneCleaner, ReferenceQueue<? super Phone> q) {
		super(referent, q);
		this.phoneCleaner = phoneCleaner;
	}

	public PhoneCleaner getPhoneCleaner(){
		return phoneCleaner;
	}

}
