
public class MainAdvanced {
    public static void main(String[] args) {
        DigitalAccount[] accounts = {
            new StudentAccount ("DA001", "Le Van C",       "c@student.edu", "pass123"),
            new LecturerAccount("DA002", "Pham Thi D",     "d@uni.edu"),
            new GuestAccount   ("DA003", "Nguyen Van Khach"),
            new LibraryCard    ("DA004", "Tran Thi E",     "RFID-8821-XZ")
        };

        System.out.println("============================================================");
        System.out.println("         HE THONG MUON SACH SO — KIEM TRA XAC THUC");
        System.out.println("============================================================");

        String[] credentials = {
            "c@student.edu:pass123",  
            "d@uni.edu",              
            "Nguyen Van Khach",       
            "RFID-8821-XZ"            
        };

        for (int i = 0; i < accounts.length; i++) {
            boolean ok = accounts[i].authenticate(credentials[i]);
            System.out.printf("[%s] %-22s | Xac thuc: %s%n",
                    accounts[i].getAccountId(),
                    accounts[i].getDisplayName(),
                    ok ? "THANH CONG ✓" : "THAT BAI ✗");
        }

        System.out.println("\n============================================================");
        System.out.println("         KIEM TRA GIOI HAN TAI XUONG (requestDownload)");
        System.out.println("============================================================");

        System.out.println("\n>> StudentAccount (gioi han 3/ngay):");
        for (int d = 0; d <= 3; d++) accounts[0].requestDownload(d);

        System.out.println("\n>> LecturerAccount (khong gioi han):");
        for (int d = 0; d <= 4; d++) accounts[1].requestDownload(d);

        System.out.println("\n>> GuestAccount (gioi han 1/ngay):");
        for (int d = 0; d <= 1; d++) accounts[2].requestDownload(d);

        System.out.println("\n>> LibraryCard (gioi han 2/ngay):");
        for (int d = 0; d <= 2; d++) accounts[3].requestDownload(d);

        System.out.println("\n============================================================");
        System.out.println("         XAC THUC SAI MAT KHAU");
        System.out.println("============================================================");
        boolean fail = accounts[0].authenticate("c@student.edu:wrongpass");
        System.out.println("StudentAccount voi mat khau sai: " + (fail ? "THANH CONG" : "THAT BAI ✗"));
    }
}
