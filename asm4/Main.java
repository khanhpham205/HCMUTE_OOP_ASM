public class Main {
    public static void main(String[] args) {

        // --- Tạo sách ---
        Book b1 = new Book("B001", "Lập Trình Java Cơ Bản", "Nguyễn Văn A", 2020, 10);
        Book b2 = new Book("B002", "Cấu Trúc Dữ Liệu & Giải Thuật", "Trần Thị B", 2019, 5);
        Book b3 = new Book("B003", "Clean Code", "Robert C. Martin", 2008, 3);

        // --- Tạo độc giả ---
        Student  s1 = new Student ("R001", "Lê Minh Khoa",   "khoa@student.edu.vn",  "22110001");
        Student  s2 = new Student ("R002", "Phạm Thị Lan",   "lan@student.edu.vn",   "22110002");
        Lecturer l1 = new Lecturer("R003", "TS. Nguyễn Hùng","hung@lecturer.edu.vn", "Khoa CNTT");
        Lecturer l2 = new Lecturer("R004", "PGS. Trần Mai",  "mai@lecturer.edu.vn",  "Khoa Toán");

        // --- Thêm vào thư viện ---
        Library library = new Library();

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.addReader(s1);
        library.addReader(s2);
        library.addReader(l1);
        library.addReader(l2);

        // --- In sachs ---
        library.printBooks();
        library.printReaders();

        // --- Kiểm chứng đa hình ---
        System.out.println("========== KIỂM TRA KẾ THỪA ==========");
        Reader[] testReaders = { s1, l1 };
        for (Reader r : testReaders) {
            System.out.println(r.getFullName()
                + " (" + r.getClass().getSimpleName() + ")"
                + " được mượn tối đa: " + r.getMaxBorrow() + " cuốn");
        }
    }
}
