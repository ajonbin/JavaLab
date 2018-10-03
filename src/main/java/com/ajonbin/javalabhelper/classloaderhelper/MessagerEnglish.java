package com.ajonbin.javalabhelper.classloaderhelper;

import com.ajonbin.javalabhelper.interfaces.IMessager;

public class MessagerEnglish implements IMessager {
	@Override
	public void sayHello() {
		System.out.println("Hello From MessagerEnglish!");
	}
}
