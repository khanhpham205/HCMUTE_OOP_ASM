import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<BorrowSlip> borrowSlips;
    private int slipCounter;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.borrowSlips = new ArrayList<>();
        this.slipCounter = 1;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public List<Book> searchByTitle(String keyword) {
        String kw = keyword.toLowerCase();
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String keyword) {
        String kw = keyword.toLowerCase();
        return books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }

    public Book findBookById(String bookId) {
        return books.stream().filter(b -> b.getBookId().equals(bookId)).findFirst().orElse(null);
    }

    public Reader findReaderById(String readerId) {
        return readers.stream().filter(r -> r.getReaderId().equals(readerId)).findFirst().orElse(null);
    }

    public long countActiveBorrows(Reader reader) {
        return borrowSlips.stream()
                .filter(s -> s.getReader().getReaderId().equals(reader.getReaderId()) && !s.isReturned())
                .count();
    }

    public BorrowSlip borrowBook(Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        if (!book.isAvailable()) {
            System.out.println("X Sach khong con trong kho.");
            return null;
        }
        if (countActiveBorrows(reader) >= reader.getMaxBorrow()) {
            System.out.printf("X %s da muon toi da %d cuon.%n", reader.getFullName(), reader.getMaxBorrow());
            return null;
        }
        book.decreaseQuantity();
        String slipId = String.format("PS%04d", slipCounter++);
        BorrowSlip slip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);
        borrowSlips.add(slip);
        System.out.printf("OK Tao phieu muon %s thanh cong.%n", slipId);
        return slip;
    }

    public void returnBook(String slipId, LocalDate returnDate) {
        BorrowSlip slip = borrowSlips.stream()
                .filter(s -> s.getSlipId().equals(slipId) && !s.isReturned())
                .findFirst().orElse(null);

        if (slip == null) {
            System.out.println("X Khong tim thay phieu muon hop le.");
            return;
        }

        slip.markReturned(returnDate);
        slip.getBook().increaseQuantity();

        int fine = slip.calculateFine(returnDate);
        if (fine > 0) {
            System.out.printf("! Tra tre %d ngay. Tien phat: %,d VND%n",
                    slip.getDaysLate(returnDate), fine);
        } else {
            System.out.println("OK Tra sach dung han. Khong co phat.");
        }
    }

    public List<BorrowSlip> getOverdueSlips(LocalDate today) {
        return borrowSlips.stream()
                .filter(s -> s.isOverdue(today))
                .collect(Collectors.toList());
    }

    public Book getMostBorrowedBook() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getTotalBorrowed))
                .orElse(null);
    }

    public Reader getMostActiveReader() {
        return readers.stream()
                .max(Comparator.comparingLong(r ->
                        borrowSlips.stream()
                                .filter(s -> s.getReader().getReaderId().equals(r.getReaderId()))
                                .count()))
                .orElse(null);
    }

    public List<Book> getBooks()            { return books; }
    public List<Reader> getReaders()        { return readers; }
    public List<BorrowSlip> getBorrowSlips(){ return borrowSlips; }
}
