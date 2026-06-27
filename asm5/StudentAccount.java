
public class StudentAccount extends DigitalAccount {
    private String email;
    private String password;

    public StudentAccount(String accountId, String displayName,
                          String email, String password) {
        super(accountId, displayName);
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean authenticate(String credential) {
        String[] parts = credential.split(":", 2);
        return parts.length == 2
                && parts[0].equals(email)
                && parts[1].equals(password);
    }

    @Override
    public int getDownloadLimit() {
        return 3;
    }
}
