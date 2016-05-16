package lab3;

public class Library {
	Integer libid;
	String title;
	String author;
	Integer pages;
	public Library(Integer libid, String title, String author, Integer pages) {
		super();
		this.libid = libid;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	public Integer getLibid() {
		return libid;
	}
	public void setLibid(Integer libid) {
		this.libid = libid;
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
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
}
