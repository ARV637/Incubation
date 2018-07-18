package java8features;

import java.util.Arrays;
import java.util.List;

public class StringContainsInt {

	public static void main(String[] args) {
		String[] arr = {"67ash23bgf", "ndfk", "jdn5s"};
		List<String> lst = Arrays.asList(arr);
		lst.stream().filter(m->m.matches("[a-zA-Z ]*\\d+.*")).forEach(System.out::println);
	}

}