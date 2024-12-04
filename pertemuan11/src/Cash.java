public class Cash extends Payment {
    private int cashTendered;

    public Cash(int amount, int cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    public int getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(int cashTendered) {
        this.cashTendered = cashTendered;
    }
}
