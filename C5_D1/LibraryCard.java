public class LibraryCard extends DigitalAccount {
    private String rfid;

    public LibraryCard(String accountId, String cardHolderName, String rfid) {
        super(accountId, cardHolderName);
        this.rfid = rfid;
    }

    @Override
    public boolean authenticate(String credential) {
        return rfid.equals(credential);
    }

    @Override
    public int getDownloadLimit() {
        return 2;
    }
}
