public enum SingletonEnum {
	//Instance
	INSTANCE;

	protected int value;

	public int getValue(){
		return this.value;
	}

	public  void setValue(int value){
		this.value = value;
	}


	public static void main(String[] args){
		SingletonEnum singletonInstance = SingletonEnum.INSTANCE;

		singletonInstance.setValue(10);
		System.out.println(singletonInstance.getValue());
	}
}
