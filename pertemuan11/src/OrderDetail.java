public class OrderDetail {
    private int quantity;
    private String taxStatus;
    private Item item;

    // Constructor
    public OrderDetail(int quantity, String taxStatus, Item item) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }

    // Methods
    public int calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public int calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public int calcTax() {
        return item.getTax() * quantity;
    }
}
