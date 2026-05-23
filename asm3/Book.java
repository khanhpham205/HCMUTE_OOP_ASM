public class Book {
    private String bookId;
    private String title;
    private String author;
    private int publishYear;
    private int quantity;
    private int totalBorrowed;

    public Book(String bookId, String title, String author, int publishYear, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.quantity = quantity;
        this.totalBorrowed = 0;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean decreaseQuantity() {
        if (!isAvailable()) return false;
        quantity--;
        totalBorrowed++;
        return true;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public String getBookId()       { return bookId; }
    public String getTitle()        { return title; }
    public String getAuthor()       { return author; }
    public int getPublishYear()     { return publishYear; }
    public int getQuantity()        { return quantity; }
    public int getTotalBorrowed()   { return totalBorrowed; }

    public void setTitle(String title)          { this.title = title; }
    public void setAuthor(String author)        { this.author = author; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public void setQuantity(int quantity)       { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) | Kho: %d", bookId, title, author, publishYear, quantity);
    }
}
