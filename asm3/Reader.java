public class Reader {
    private String readerId;
    private String fullName;
    private String email;
    private ReaderType readerType;

    public Reader(String readerId, String fullName, String email, ReaderType readerType) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.email = email;
        this.readerType = readerType;
    }

    public int getMaxBorrow() {
        return readerType.getMaxBorrow();
    }

    public String getReaderId()       { return readerId; }
    public String getFullName()       { return fullName; }
    public String getEmail()          { return email; }
    public ReaderType getReaderType() { return readerType; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email)       { this.email = email; }
    public void setReaderType(ReaderType t)  { this.readerType = t; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s", readerId, fullName, readerType, email);
    }
}
