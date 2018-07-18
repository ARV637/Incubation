package java8features;

interface TestInd {

	default void fun1(int i) {
		System.out.println("hello 1");
	}
	
	default void fun2() {
		System.out.println("hello 1");
	}
	
	public void m1(int i,int j);
	//public void m2(int i,int j);
	
}

public class Myclass{
	public static void main(String[] args) {
		TestInd tn = (i,j)->System.out.println("Multi"+(i*j));
		tn.fun1(20);
		
		tn.m1(10, 20);
		
		
		
	}
}