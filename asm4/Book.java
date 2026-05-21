public class Book {
    private String bookID;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;

    public Book(String bookID, String title, String author, int publishYear, int quantity) {
        this.bookID      = bookID;
        this.title       = title;
        this.author      = author;
        this.publishYear = publishYear;
        this.quantity    = quantity;
    }

    // Getter
    public String getBookID()      { return bookID; }
    public String getTitle()       { return title; }
    public String getAuthor()      { return author; }
    public int    getPublishYear() { return publishYear; }
    public int    getQuantity()    { return quantity; }

    // Setter
    public void setBookID(String bookID)           { this.bookID = bookID; }
    public void setTitle(String title)             { this.title = title; }
    public void setAuthor(String author)           { this.author = author; }
    public void setPublishYear(int publishYear)    { this.publishYear = publishYear; }
    public void setQuantity(int quantity)          { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Mã sách: " + bookID
             + " | Tên: " + title
             + " | Tác giả: " + author
             + " | Năm XB: " + publishYear
             + " | Số lượng: " + quantity;
    }
}
