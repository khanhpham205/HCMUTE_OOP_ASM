public class Book {
    private String bookId;
    private String title;
    private String author;
    private int year;
    private int quantity;

    public Book(String bookId, String title, String author, int year, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "[" + bookId + "] " + title + " — " + author + " (" + year + ") | So luong: " + quantity;
    }
}
