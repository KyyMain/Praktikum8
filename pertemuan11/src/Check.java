public class Check extends Payment {
    private String name;
    private String bankID;

    public Check(int amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    public boolean authorized() {
        return true; // Example
    }
}
