public class Reader {
    private String readerID;
    private String fullName;
    private String email;

    public Reader(String readerID, String fullName, String email) {
        this.readerID = readerID;
        this.fullName = fullName;
        this.email = email;
    }

    // Getters
    public String getReaderID() { return readerID; }
    public String getFullName()  { return fullName; }
    public String getEmail()     { return email; }

    // Setters
    public void setReaderID(String readerID) { this.readerID = readerID; }
    public void setFullName(String fullName)  { this.fullName = fullName; }
    public void setEmail(String email)        { this.email = email; }

    // Trả về số sách tối đa được mượn; lớp con sẽ ghi đè
    public int getMaxBorrow() {
        return 0;
    }

    @Override
    public String toString() {
        return "Mã độc giả: " + readerID
             + " | Họ tên: " + fullName
             + " | Email: " + email
             + " | Mượn tối đa: " + getMaxBorrow() + " cuốn";
    }
}
