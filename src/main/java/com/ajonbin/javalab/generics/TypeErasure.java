package com.ajonbin.javalab.generics;

class Node<T>{
	public T value;

	public Node(T value){
		this.value = value;
	}
	public void setNode(T value){
		this.value = value;
	}
}

class IntegerNode extends Node<Integer>{
	public IntegerNode(Integer value){
		super(value);
	}
	public void setNode(Integer value){
		super.setNode(value);
	}
}
public class TypeErasure {
	public static void main(String[] argv){
		IntegerNode integerNode = new IntegerNode(5);
		Node node = integerNode;
		//Runtime Error: node.setNode("Hello");
	}
}
