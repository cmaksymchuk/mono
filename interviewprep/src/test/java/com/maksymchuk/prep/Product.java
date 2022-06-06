package com.maksymchuk.prep;

public class Product implements Comparable<Product>{
	
	    private String title;
	    private int popularity;
	    private int price;
		public Product(String title, int popularity, int price) {
			super();
			this.title = title;
			this.popularity = popularity;
			this.price = price;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getPopularity() {
			return popularity;
		}
		public void setPopularity(int popularity) {
			this.popularity = popularity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public int compareTo(Product o) {
			// TODO Auto-generated method stub
			return 0;
		}



}
