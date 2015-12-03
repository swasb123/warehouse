package models;

import java.util.*;

public class Product {

	private static List<Product> products;

	static {
		products = new ArrayList<Product>();

		products.add(new Product("1111111111111", "PaperClips 1",
				"PaperClips Description 1"));
		products.add(new Product("2222222222222", "PaperClips 2",
				"PaperClips Description 2"));
		products.add(new Product("3333333333333", "PaperClips 3",
				"PaperClips Description 3"));
		products.add(new Product("4444444444444", "PaperClips 4",
				"PaperClips Description 4"));
		products.add(new Product("5555555555555", "PaperClips 5",
				"PaperClips Description 5"));
	}
	
	public Product(){
		
	}

	public String ean;
	public String name;
	public String description;

	public Product(String ean, String name, String description) {
		this.ean = ean;
		this.name = name;
		this.description = description;
	}

	public String toString() {
		return String.format("%s - %s", ean, name);
	}

	public static List<Product> findall() {
		return new ArrayList<Product>(products);
	}

	public static Product findByEan(String ean) {
		for (Product candidate : products) {
			if (candidate.ean.equals(ean)) {
				return candidate;
			}
		}
		return null;
	}

	public static List<Product> findByName(String term) {
		final List<Product> results = new ArrayList<Product>();

		for (Product candidate : products) {
			if (candidate.name.toLowerCase().contains(term.toLowerCase())) {
				results.add(candidate);
			}
		}
		return results;
	}

	public static boolean remove(Product product) {
		return products.remove(product);
	}

	public void save() {
		products.remove(findByEan(this.ean));
		products.add(this);
	}

}
