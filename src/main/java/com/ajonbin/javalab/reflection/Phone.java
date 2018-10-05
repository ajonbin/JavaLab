package com.ajonbin.javalab.reflection;

public class Phone {
	public String phone_public_os;
	public String phone_public_brand;
	protected String[] phone_protected_apps;

	private float phone_private_powerUsage;

	private Phone(){

	}

	public Phone(String os){
		this.phone_public_os = os;
	}

	public Phone(String os, String phone_public_brand){
		this.phone_public_os = os;
		this.phone_public_brand = phone_public_brand;
	}

	public String getOs(){
		return this.phone_public_os;
	}

	public String getPhone_public_brand(){
		return this.phone_public_brand;
	}

	protected String[] getPhone_protected_apps() {
		return phone_protected_apps;
	}

	protected void setPhone_protected_apps(String[] phone_protected_apps) {
		this.phone_protected_apps = phone_protected_apps;
	}

	private float getPhone_private_powerUsage() {
		return phone_private_powerUsage;
	}

	private void setPhone_private_powerUsage(float phone_private_powerUsage) {
		this.phone_private_powerUsage = phone_private_powerUsage;
	}

}
