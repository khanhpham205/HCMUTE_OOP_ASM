package asm2;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance < 0) {
            System.out.print("Cảnh báo: Số dư không hợp lệ");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Getter cho cả 3 biến
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.ownerName = name;
        } else {
            System.out.print("Lỗi: Tên chủ tài khoản không được rỗng.");
        }
    }

    public void cashIn(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("Nạp tiền thành công:" + amount + "| Số dư hiện tại: " + balance);
        } else {
            System.out.print("Lỗi: Số tiền nạp phải lớn hơn 0.");
        }
    }

    public void CashOut(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.print("Rút tiền thành công: " + amount + " | Số dư hiện tại: " + balance);
        } else if (amount <= 0) {
            System.out.print("Lỗi: Số tiền rút phải lớn hơn 0.");
        } else {
            System.out.print("Lỗi: Số dư không đủ để rút " + amount);
        }
    }

    public void displayInfo() {
        int len = accountNumber.length();
        String masked = (len > 4)
            ? "*".repeat(len - 4) + accountNumber.substring(len - 4)
            : accountNumber;
        System.out.print("Thông tin tài khoản");
        System.out.print("    Số tài khoản : " + masked);
        System.out.print("    Chủ tài khoản: " + ownerName);
        System.out.print( "    Số dư :" +balance);
    }

    public void transfer(BankAccount other, double amount) {
        if (other == null) {
            System.out.print("Lỗi: Tài khoản đích không hợp lệ.");
            return;
        }
        else if (amount <= 0) {
            System.out.print("Lỗi: Số tiền chuyển phải lớn hơn 0.");
            return;
        }
        else if (amount > this.balance) {
            System.out.print("Lỗi: Số dư không đủ để chuyển " + amount);
            return;
        }

        this.balance -= amount;
        other.balance += amount;
        System.out.printf(
            "Chuyển " + amount + 
            " từ " + this.ownerName + " sang " + 
            other.ownerName + " thành công."
        );
    }
}

