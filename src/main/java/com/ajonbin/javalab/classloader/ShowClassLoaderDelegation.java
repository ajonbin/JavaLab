package com.ajonbin.javalab.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class ShowClassLoaderDelegation {
	static public void main(String[] argv){

		 ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		 do{
		 		System.out.println(classLoader);
		 		//Print out Class Load Path
		 		for(URL url: ((URLClassLoader)classLoader).getURLs()){
		 			System.out.println("\t" + url.getPath());
				}

		 }while((classLoader = classLoader.getParent()) != null);
		System.out.println("Top ClassLoader: Bootstrap ClassLoader");
	}
}
