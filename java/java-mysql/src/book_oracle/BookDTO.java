package book_oracle;

public class BookDTO {

	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String info = "";
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return isbn + "\t| " + title + "\t| " + author + "\t| " + publisher
				+ "\t| " + price + "\t| " + info;
	}
	
	public BookDTO(int isbn, String title, String author, String publisher, int price, String info) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.info = info;
	}
	public BookDTO(int isbn, String title, String author, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	public BookDTO() {
		super();
	}
	
}
