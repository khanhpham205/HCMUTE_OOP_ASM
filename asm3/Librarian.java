import java.time.LocalDate;

public class Librarian {
    private String staffId;
    private String name;
    private Library library;

    public Librarian(String staffId, String name, Library library) {
        this.staffId = staffId;
        this.name = name;
        this.library = library;
    }

    public BorrowSlip processBorrow(String readerId, String bookId, LocalDate borrowDate, LocalDate dueDate) {
        Reader reader = library.findReaderById(readerId);
        Book book = library.findBookById(bookId);
        if (reader == null) { System.out.println("X Khong tim thay doc gia."); return null; }
        if (book == null)   { System.out.println("X Khong tim thay sach.");    return null; }
        return library.borrowBook(reader, book, borrowDate, dueDate);
    }

    public void processReturn(String slipId, LocalDate returnDate) {
        library.returnBook(slipId, returnDate);
    }

    public String getStaffId() { return staffId; }
    public String getName()    { return name; }
}
