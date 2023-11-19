package Model;

import java.util.Date;

public class Books {
    private int id;
    public String bookName;
    public int pageNumber;
    public Topic topic;
    public Date realeseDate;
    public Author author;

    public Books(int id, String bookName, int pageNumber, Topic topic, Date realeseDate, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.topic = topic;
        this.realeseDate = realeseDate;
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public Topic getTopic() {
        return topic;
    }

    public Date getRealeseDate() {
        return realeseDate;
    }

    public Author getAuthor() {
        return author;
    }
}
