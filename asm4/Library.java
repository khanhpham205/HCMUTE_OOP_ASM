import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book>   books   = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    // Thêm sách
    public void addBook(Book book) {
        books.add(book);
    }

    // Thêm độc giả (Student hoặc Lecturer đều được)
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // In danh sách sách
    public void printBooks() {
        System.out.println("========== DANH SÁCH SÁCH ==========");
        if (books.isEmpty()) {
            System.out.println("  (Chưa có sách nào)");
        } else {
            for (Book b : books) {
                System.out.println("  " + b);
            }
        }
        System.out.println();
    }

    // In danh sách độc giả
    public void printReaders() {
        System.out.println("========== DANH SÁCH ĐỘC GIẢ ==========");
        if (readers.isEmpty()) {
            System.out.println("  (Chưa có độc giả nào)");
        } else {
            for (Reader r : readers) {
                System.out.println("  " + r);
            }
        }
        System.out.println();
    }
}
