package com.ajonbin.javalab.classloader;

import com.ajonbin.javalabhelper.interfaces.IMessager;

import java.io.IOException;
import java.nio.file.*;

public class StaticMessagerClassLoader extends ClassLoader {
	private ClassLoader parent;
	final private String classPath = "impclasses/com/ajonbin/javalabhelper/classloaderhelper/MessagerEnglish.class";

	protected StaticMessagerClassLoader() {
		this(ClassLoader.getSystemClassLoader());
	}

	protected StaticMessagerClassLoader(ClassLoader parent) {
		super(parent);
		this.parent = parent;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clz;
		try {
			clz = parent.loadClass(name);
		} catch (ClassNotFoundException e){
			byte[] clzBytes = loadMessagerClass();
			clz = defineClass(name,clzBytes,0,clzBytes.length);
		}

		return clz;
	}

	private byte[] loadMessagerClass(){
		try{
			Path p = FileSystems.getDefault().getPath(classPath);
			byte[] data = Files.readAllBytes(p);
			return  data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		StaticMessagerClassLoader ownLoader = new StaticMessagerClassLoader();
		try {
			Class clz = ownLoader.findClass("com.ajonbin.javalabhelper.classloaderhelper.MessagerEnglish");
			IMessager messager = (IMessager) clz.newInstance();
			messager.sayHello();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
}
