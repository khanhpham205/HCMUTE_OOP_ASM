public class Student extends Reader {
    private String studentID;
    private String cardType = "Thẻ Sinh Viên";

    public Student(String readerID, String fullName, String email, String studentID) {
        super(readerID, fullName, email);
        this.studentID = studentID;
    }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString()
             + " | MSSV: " + studentID
             + " | Loại thẻ: " + cardType;
    }
}
