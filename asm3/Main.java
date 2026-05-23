import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Librarian librarian;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        librarian = new Librarian("TT001", "Nguyen Thu Thu", library);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Chon: ");
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> searchBook();
                case 4 -> showOverdue();
                case 5 -> showStats();
                case 0 -> running = false;
                default -> System.out.println("Lua chon khong hop le.");
            }
        }
        System.out.println("Tam biet!");
    }

    static void printMenu() {
        System.out.println("\n===== THU VIEN TRUONG =====");
        System.out.println("1. Muon sach");
        System.out.println("2. Tra sach");
        System.out.println("3. Tim kiem sach");
        System.out.println("4. Phieu qua han");
        System.out.println("5. Thong ke");
        System.out.println("0. Thoat");
    }

    static void borrowBook() {
        System.out.print("Ma doc gia: ");  String rid = sc.nextLine().trim();
        System.out.print("Ma sach: ");     String bid = sc.nextLine().trim();
        LocalDate today   = LocalDate.now();
        LocalDate dueDate = today.plusDays(14);
        librarian.processBorrow(rid, bid, today, dueDate);
    }

    static void returnBook() {
        System.out.print("Ma phieu muon: "); String slipId = sc.nextLine().trim();
        librarian.processReturn(slipId, LocalDate.now());
    }

    static void searchBook() {
        System.out.println("Tim theo: 1-Ten  2-Tac gia");
        int opt = readInt("Chon: ");
        System.out.print("Tu khoa: "); String kw = sc.nextLine().trim();
        List<Book> results = (opt == 1)
                ? library.searchByTitle(kw)
                : library.searchByAuthor(kw);
        if (results.isEmpty()) System.out.println("Khong tim thay.");
        else results.forEach(System.out::println);
    }

    static void showOverdue() {
        System.out.print("Nhap ngay hien tai (yyyy-MM-dd): ");
        LocalDate today = LocalDate.parse(sc.nextLine().trim());
        List<BorrowSlip> overdue = library.getOverdueSlips(today);
        if (overdue.isEmpty()) System.out.println("Khong co phieu qua han.");
        else overdue.forEach(System.out::println);
    }

    static void showStats() {
        Book topBook = library.getMostBorrowedBook();
        Reader topReader = library.getMostActiveReader();
        System.out.println("Sach duoc muon nhieu nhat: " + (topBook != null ? topBook : "N/A"));
        System.out.println("Doc gia muon nhieu nhat:   " + (topReader != null ? topReader : "N/A"));
    }

    static void seedData() {
        library.addBook(new Book("B001", "Lap trinh Java co ban", "Nguyen Van A", 2020, 3));
        library.addBook(new Book("B002", "Cau truc du lieu va giai thuat", "Tran Thi B", 2019, 2));
        library.addBook(new Book("B003", "Clean Code", "Robert C. Martin", 2008, 1));

        library.addReader(new Reader("R001", "Le Van C", "levanc@sv.edu.vn", ReaderType.SINH_VIEN));
        library.addReader(new Reader("R002", "Pham Thi D", "phamthid@gv.edu.vn", ReaderType.GIANG_VIEN));
    }

    static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
