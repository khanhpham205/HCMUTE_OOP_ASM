public class Lecturer extends Reader {
    private String department;
    private String cardType = "Thẻ Giảng Viên";

    public Lecturer(String readerID, String fullName, String email, String department) {
        super(readerID, fullName, email);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString()
             + " | Khoa: " + department
             + " | Loại thẻ: " + cardType;
    }
}
