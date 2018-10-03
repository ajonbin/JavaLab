package com.ajonbin.javalab.reference;

import java.lang.ref.ReferenceQueue;

public class UseReferenceQueue {
	public static void main(String argv[]){
		Phone phone = new Phone();
		PhoneCleaner phoneCleaner = new PhoneCleaner();
		ReferenceQueue<Phone> phoneReferenceQueue = new ReferenceQueue<>();

		PhonePhantomReference phonePhantomReference = new PhonePhantomReference(phone,phoneCleaner,phoneReferenceQueue);


		System.out.println("Before GC()");
		PhonePhantomReference phantomRefBeforeGC = (PhonePhantomReference) phoneReferenceQueue.poll();
		if(phantomRefBeforeGC == null){
			System.out.println("Weak Reference has not been put into ReferenceQueue");
		}

		phone = null;
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("After GC()");
		PhonePhantomReference phantomRefAftereGC = (PhonePhantomReference) phoneReferenceQueue.poll();
		if(phantomRefAftereGC != null){
			System.out.println("Weak Reference has been put into ReferenceQueue");
			phantomRefAftereGC.getPhoneCleaner().clean();
		}

	}
}
