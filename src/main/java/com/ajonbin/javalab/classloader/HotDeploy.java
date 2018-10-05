package com.ajonbin.javalab.classloader;

import com.ajonbin.javalabhelper.interfaces.IMessager;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class HotDeploy {
	static ClassLoader classLoader;
	static IMessager messager;
	public static void main(String[] args) throws Exception {

		reloadMessagerFromLib();
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			System.out.println("Enter H(hello), R(reload) or Q(quit)");
			String input = sysin.readLine().toUpperCase();
			if (input.equals("H")){
				messager.sayHello();
			}else if(input.equals("R")){
				reloadMessagerFromLib();
			}else if (input.equals("Q")){
				return;
			}else {
				System.out.println("Enter HELLO, RELOAD or QUIT");
			}
		}
	}

	public static void reloadMessagerFromLib() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		URL[] urls = new URL[]{
			new File("./impclasses").toURI().toURL()
		};

		classLoader = new URLClassLoader(urls);
		messager = (IMessager) classLoader.loadClass("com.ajonbin.javalabhelper.classloaderhelper.MessagerEnglish").newInstance();
	}

}
