package java8features;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		OptionalClass java8Tester = new OptionalClass();
		Integer value1 = null;
		Integer value2 = new Integer(10);

		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);

		System.out.println(java8Tester.sum(a, b));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());
		Integer value1 = a.orElse(new Integer(0));
		Integer value2 = b.get();
		return value1 + value2;
	}

}
