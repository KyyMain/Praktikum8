public class Credit extends Payment {
    private String number;
    private String type;
    private String expDate;

    public Credit(int amount, String number, String type, String expDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    public boolean authorized() {
        return true; // Example
    }
}
