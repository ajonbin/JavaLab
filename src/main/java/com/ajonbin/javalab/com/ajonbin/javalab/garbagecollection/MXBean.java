package com.ajonbin.javalab.com.ajonbin.javalab.garbagecollection;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class MXBean {

	public static void main(String argv[]){
		List<GarbageCollectorMXBean> mxBeans = ManagementFactory.getGarbageCollectorMXBeans();
		for(GarbageCollectorMXBean bean : mxBeans){
			System.out.println("Name: "+ bean.getName());
			System.out.println("Number of collections: " + bean.getCollectionCount());
			System.out.println("Collection time: " + bean.getCollectionTime());
			System.out.println("Pool name: ");

			for(String name : bean.getMemoryPoolNames()){
				System.out.println("\t" + name);
			}

			System.out.println();

		}

	}
}
