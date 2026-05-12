public class Book {
    private String title;
    private String author;
    private int year;
    private int price;


    public Book(String title, String author, int year, int price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public void showInfo() {
        System.out.println(
                "Sách: " + title + " | Tác giả: " + author + " | Năm xuất bản: " + year + " | Giá: " + price + " VNĐ"
        );
    }

}
