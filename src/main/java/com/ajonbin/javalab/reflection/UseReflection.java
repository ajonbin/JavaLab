package com.ajonbin.javalab.reflection;

import java.lang.reflect.*;

public class UseReflection {
	public static void main(String[] args) throws Exception {
		listHierarcy();
		System.out.println();

		listClassConstructors();
		System.out.println();

		listFields();
		listDeclaredFields();
		System.out.println();

		listClassMethods();
		System.out.println();

		callConstructor();
		System.out.println();

		callMethod();
		System.out.println();

		setField();
		System.out.println();

		operateArrayField();
		System.out.println();

	}


	public static void listHierarcy(){
		System.out.println("---- List Hierarchy ---");
		Class clz = AndroidPhone.class;

		while (clz != null){
			System.out.println(clz.getName());
			clz = clz.getSuperclass();
		}
	}
	public static void listClassConstructors() throws Exception {
		Class clz = AndroidPhone.class;

		System.out.println("---- List Constructors ---");
		listConstructors(clz.getConstructors());

		System.out.println("---- List Declared Constructors ---");
		listConstructors(clz.getDeclaredConstructors());

	}
	public static void listConstructors(Constructor[] constructors) {
		for (Constructor constructor : constructors){
			if (constructor.getParameterCount() == 0){
				String conInfo = String.format("%d %s ( )", constructor.getModifiers(),constructor.getName());
				System.out.println(conInfo);
			}else{
				StringBuilder builder = new StringBuilder();
				builder.append(String.format("%d %s ( ", constructor.getModifiers(),constructor.getName()));
				for (Parameter parameter : constructor.getParameters()){
					builder.append(parameter.getType().getName());
					builder.append(" ");
				}
				builder.append(")");
				System.out.println(builder.toString());
			}
		}
	}

	public static void listFields(){
		System.out.println("---- List Fields ---");
		Class clz = AndroidPhone.class;

		for(Field field : clz.getFields()){
			System.out.println(String.format("%s : %s",field.getType().getName(),field.getName()));
		}
	}

	public static void listDeclaredFields(){
		System.out.println("---- List Declared Fields ---");
		Class clz = AndroidPhone.class;

		for(Field field : clz.getDeclaredFields()){
			System.out.println(String.format("%s : %s",field.getType().getName(),field.getName()));
		}
	}

	public static void listClassMethods() {

		Class clz = AndroidPhone.class;

		System.out.println("---- List Methods ----");
		listMethods(clz.getMethods());

		System.out.println("---- List Declared Methods ----");
		listMethods(clz.getDeclaredMethods());

	}
	public static void listMethods(Method[] methods){
		for (Method method : methods){
			if (method.getParameterCount() == 0){
				System.out.println(String.format("%s ( )", method.getName()));
			}else {
				StringBuilder builder = new StringBuilder();
				builder.append(method.getName());
				builder.append("(");
				for(Parameter parameter : method.getParameters()){
					builder.append(parameter.getType().getName());
					builder.append(" ");
					builder.append(parameter.getName());
					builder.append(",");
				}
				builder.append(")");
				System.out.println(builder.toString());
			}
		}
	}

	public static void callConstructor() throws Exception {

		System.out.println("---- Call AndroidPhone(String brand) ----");
		Class clz = AndroidPhone.class;

		AndroidPhone androidPhone  = (AndroidPhone)clz.getDeclaredConstructor(String.class).newInstance("Smartisan");

		System.out.println(androidPhone.getPhone_public_brand());

	}

	public static void callMethod() throws Exception {
		System.out.println("---- Call AndroidPhone::setAndroidPhone_public_version() ----");
		Class clz = AndroidPhone.class;

		AndroidPhone androidPhone  = (AndroidPhone)clz.getDeclaredConstructor(String.class).newInstance("Smartisan");

		clz.getMethod("setAndroidPhone_public_version", String.class).invoke(androidPhone,"1.0.0");
		System.out.println(androidPhone.getAndroidPhone_public_version());

	}

	public static void setField() throws Exception {
		System.out.println("---- Set Private Field ----");
		Class clz = AndroidPhone.class;
		AndroidPhone androidPhone  = (AndroidPhone)clz.getDeclaredConstructor(String.class).newInstance("Smartisan");

		Field privateFiled = clz.getDeclaredField("androidPhone_private_model");
		privateFiled.setAccessible(true);
		privateFiled.set(androidPhone,"Model_U2Pro");

		Method privateMethod = clz.getDeclaredMethod("getAndroidPhone_private_model");
		privateMethod.setAccessible(true);
		String model = (String)privateMethod.invoke(androidPhone,null);
		System.out.println(model);

	}

	public static void operateArrayField() throws Exception{
		System.out.println("---- Operate Array Field ----");
		Class clz = AndroidPhone.class;
		AndroidPhone androidPhone  = (AndroidPhone)clz.getDeclaredConstructor(String.class).newInstance("Smartisan");

		Field apps = clz.getDeclaredField("androidPhone_public_array_sysApps");

		Array.set(apps.get(androidPhone),0,"handershaker");
		Array.set(apps.get(androidPhone),1,"smartisan notes");

		for (String app: (String[])apps.get(androidPhone)){
			System.out.println(app);
		}
	}
}

