package com.ajonbin.javalab.reference;

import java.util.WeakHashMap;

public class UseWeakHaspMap {
	public static void main(String argv[]){
		Phone googlePhone = new Phone();
		WeakHashMap<Phone,PhoneMetaData> phoneMetaDatas = new WeakHashMap<>();
		PhoneMetaData googlePhoneMeta = new PhoneMetaData();

		phoneMetaDatas.put(googlePhone,googlePhoneMeta);

		System.out.println("Getting Metadata from WeakHashMap:");
		System.out.println(phoneMetaDatas.get(googlePhone));
		System.out.println(String.format("WeakHashMap has %d elements", phoneMetaDatas.size()));

		googlePhone = null;
		//System.gc();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("After GC():");
		System.out.println(phoneMetaDatas.containsValue(googlePhoneMeta));
		if(phoneMetaDatas.size() == 0){
			System.out.println("MetaData is also released when Phone is GCed");
		}else {
			System.out.println("Oops, MetaData is not released !!");
		}
	}
}
