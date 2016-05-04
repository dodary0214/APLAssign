package APL.assign.dodary;

public class Testcse {

	public static void main(String[] args) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		DynamicClassProvider.register("Print1", "dodary", "APL.assign.dodary.Printable1");
		Object o = DynamicClassProvider.newInstance("Print1", "dodary");
		((IPrintable)o).printName();
	}

}
