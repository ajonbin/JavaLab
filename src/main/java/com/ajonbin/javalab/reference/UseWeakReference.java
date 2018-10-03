package com.ajonbin.javalab.reference;

import java.lang.ref.WeakReference;

public class UseWeakReference {
	public static void main(String argv[]){
		Phone phone = new Phone();
		WeakReference<Phone> phoneWeakReference = new WeakReference<>(phone);

		System.out.println("Strong Reference is: " + phone);
		System.out.println("Weak Reference is: " + phoneWeakReference);
		System.out.println("Ref from  Weak is: " + phoneWeakReference.get());

		System.out.println("\nAfter Set Strong Ref to Null:");
		phone = null;
		System.out.println("Weak Reference is: " + phoneWeakReference);
		System.out.println("Ref from  Weak is: " + phoneWeakReference.get());

		System.out.println("\nAfter GC():");
		System.gc();
		System.out.println("Weak Reference is: " + phoneWeakReference);
		System.out.println("Ref from  Weak is: " + phoneWeakReference.get());

	}
}
