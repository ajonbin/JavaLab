package com.ajonbin.javalab.reflection;

public class AndroidPhone extends Phone {
	public String androidPhone_public_version;
	protected int androidPhone_protected_build;
	private String androidPhone_private_model;

	public String[] androidPhone_public_array_sysApps;

	public String getAndroidPhone_public_version() {
		return androidPhone_public_version;
	}

	public void setAndroidPhone_public_version(String andoridPhone_public_version) {
		this.androidPhone_public_version = andoridPhone_public_version;
	}

	protected int getAndroidPhone_protected_build() {
		return androidPhone_protected_build;
	}

	protected void setAndroidPhone_protected_build(int androidPhone_protected_build) {
		this.androidPhone_protected_build = androidPhone_protected_build;
	}

	private String getAndroidPhone_private_model() {
		return androidPhone_private_model;
	}

	private void setAndroidPhone_private_model(String androidPhone_private_model) {
		this.androidPhone_private_model = androidPhone_private_model;
	}


	public AndroidPhone() {
		super("Android");
		androidPhone_public_array_sysApps = new String[10];
	}
	public AndroidPhone(String brand){
		super("Android", brand);
		androidPhone_public_array_sysApps = new String[10];
	}


}
