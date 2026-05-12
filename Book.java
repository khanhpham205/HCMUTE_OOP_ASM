public class Book {
    private String title;
    private String author;
    private double price; // Đổi sang double theo yêu cầu đề bài
    private boolean inStock;

    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public void printInfo() {
        System.out.println(
            "Sách: " + title + " | " + 
            "Tác giả: " + author + " | " + 
            "Giá: " + price + " | " + 
            "Còn hàng: " + inStock
        );
    }

    public void applyDiscount(double percent) {
        this.price = this.price * (1 - percent / 100);
    }
}