package java8features;

import java.util.ArrayList;

public class TestLambdaExpression01 {

	public static void main(String[] args) {
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		arrL.add(1);
		arrL.add(2);
		arrL.add(3);
		arrL.add(4);

		arrL.forEach(System.out::println);

		arrL.forEach(n -> {
			if (n % 2 == 0)
				System.out.println(n);
		});
	}
}