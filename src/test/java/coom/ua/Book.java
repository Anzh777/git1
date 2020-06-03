package coom.ua;

import java.util.Objects;

public class Book {

    public String title;
    public String author;
    boolean Best;

    public Book() {
    }

    Book(String title, String author) {

        this.title = title;
        this.author = author;

    }

    public boolean isBest() {
        return Best;
    }

    public void setBest(boolean best) {
        Best = best;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", Best=" + Best +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Best == book.Best &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, Best);
    }


}


