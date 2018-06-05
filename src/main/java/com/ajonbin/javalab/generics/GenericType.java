package com.ajonbin.javalab.generics;

public class GenericType<T, S> {

	public T value;
	public S subValue;

	public S getSubValue() {
		return subValue;
	}

	public void setSubValue(S subValue) {
		this.subValue = subValue;
	}


	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return value.toString() + " : " + subValue.toString();
	}
}
