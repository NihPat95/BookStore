package vo;
import java.util.Date;

public class BookRecords {
private String ISBN;
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public String getPublisher() {
	return Publisher;
}
public void setPublisher(String publisher) {
	Publisher = publisher;
}
public String getGenre() {
	return Genre;
}
public void setGenre(String genre) {
	Genre = genre;
}
public int getPages() {
	return Pages;
}
public void setPages(int pages) {
	Pages = pages;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public Date getDate() {
	return Date;
}
public void setDate(Date date) {
	Date = date;
}
public String getSynopsis() {
	return Synopsis;
}
public void setSynopsis(String synopsis) {
	Synopsis = synopsis;
}
private String Title;
private String Author;
private String Publisher;
private String Genre;
private int Pages;
private int Price;
private String Type;
private Date Date;
private String Synopsis;

}
