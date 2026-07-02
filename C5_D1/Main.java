
public class Main {

    public static void main(String[] args) {
        Book b1 = new Book(
            "B001", 
            "Lap trinh Java", 
            "Nguyen Manh", 
            2022, 
            10
        );
        Book b2 = new Book(
            "B002", 
            "CTDL va GT", 
            "Tran Hung", 
            2021, 
            5
        );

        Reader sv = new Student(
            "R001", "Le Van C",
            "c@student.edu"
        );
        Reader gv = new Lecturer(
            "R002", 
            "Pham Thi D", 
            "d@uni.edu"
        );

        Library lib = new Library();
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addReader(sv);
        lib.addReader(gv);

        lib.showAllBooks();
        System.out.println();
        lib.showAllReaders();
        System.out.println();
        lib.showLateFees(7);

        System.out.println("\nHan muon:");
        Reader[] allReaders = {sv, gv};
        for (Reader r : allReaders) {
            System.out.println(r.getFullName() + ": " + r.getMaxBorrow() + " cuon");
        }
    }
}
