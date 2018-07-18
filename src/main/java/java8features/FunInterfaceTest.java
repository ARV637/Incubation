package java8features;

public class FunInterfaceTest {
	
	@FunctionalInterface
	interface funInt1{
		int operation(int x, int y);
	}
	
	@FunctionalInterface
	interface funInt2{
		void sayMessage(String msg);
	}
	
	private int operate(int i, int j, funInt1 funObj) {
		return funObj.operation(i, j);
	}
	
	public static void main(String[] args) {
		
		funInt1 add = (x, y) -> x+y;
		
		funInt1 mul = (x, y) -> x*y;
		
		FunInterfaceTest fit = new FunInterfaceTest();
		
		System.out.println(fit.operate(4, 5, add));
		
		System.out.println(fit.operate(5, 5, mul));
		
		funInt2 msg = message -> System.out.println("Complete "+ message);
		
		msg.sayMessage("Incubation");
	}

}
