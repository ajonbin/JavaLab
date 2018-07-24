
public class VarArgs {
	public void printMsgs(String... msgs){
		System.out.println(msgs.getClass());

		for(String msg : msgs){
			System.out.println(msg);
		}
	}

	public void printObjs(Object... objs){
		System.out.println(objs.getClass());

		for(Object obj : objs){
			System.out.println(obj);
		}
	}


	public static void main(String[] argv) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class clz = Class.forName("VarArgs");
		VarArgs varArgs = (VarArgs) clz.newInstance();
		varArgs.printMsgs("hello","1","2");
		varArgs.printObjs(1,2,3,4,"a",'b');

	}
}
