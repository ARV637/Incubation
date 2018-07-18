package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamExample {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		List<Float> productPriceList = new ArrayList<Float>();
		
		for (Product product : productsList) {
			// filtering data of list
			if (product.price < 30000) {
				productPriceList.add(product.price); // adding price to a productPriceList
			}
		}
		System.out.println(productPriceList); // displaying data
		
		//filtering using stream filter method
		List<Float> productPriceList2 = productsList.stream()
				.filter(p -> p.price>30000)
				.map(p->p.price)
				.collect(Collectors.toList());
		System.out.println(productPriceList2);
		
		//iterating the filtered value using stream
		productsList.stream().filter(p -> p.price == 30000).forEach(p-> System.out.println(p.name));
	}
}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}