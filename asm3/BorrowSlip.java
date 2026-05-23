import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String slipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public BorrowSlip(String slipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.slipId = slipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returned = false;
    }

    public boolean isOverdue(LocalDate today) {
        if (returned) return false;
        return today.isAfter(dueDate);
    }

    public long getDaysLate(LocalDate returnDate) {
        return ChronoUnit.DAYS.between(dueDate, returnDate);
    }

    public int calculateFine(LocalDate returnDate) {
        long daysLate = getDaysLate(returnDate);
        return Fine.calculate(daysLate);
    }

    public void markReturned(LocalDate returnDate) {
        this.returned = true;
        this.returnDate = returnDate;
    }

    public String getSlipId()        { return slipId; }
    public Reader getReader()        { return reader; }
    public Book getBook()            { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate()    { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned()      { return returned; }

    @Override
    public String toString() {
        return String.format("Phieu [%s] | %s muon \"%s\" | Muon: %s | Han: %s | %s",
                slipId, reader.getFullName(), book.getTitle(),
                borrowDate, dueDate, returned ? "Da tra" : "Chua tra");
    }
}
