package model.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.book.nested.Additional;

import java.util.Objects;

public class Book {

    @JsonProperty
    private int bookId;
    @JsonProperty
    private String bookName;
    @JsonProperty
    private String bookLanguage;
    @JsonProperty
    private String bookDescription;
    @JsonProperty
    private Additional additional;
    @JsonProperty
    private int publicationYear;

    public Book() {
    }

    public Book(int bookId, String bookName, String bookLanguage, String bookDescription, Additional additional, int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.additional = additional;
        this.publicationYear = publicationYear;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Additional getAdditional() {
        return additional;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                publicationYear == book.publicationYear &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookLanguage, book.bookLanguage) &&
                Objects.equals(bookDescription, book.bookDescription) &&
                Objects.equals(additional, book.additional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, bookLanguage, bookDescription, additional, publicationYear);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookLanguage='" + bookLanguage + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", additional=" + additional +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
