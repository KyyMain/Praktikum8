public class Item {
    private int shippingWeight;
    private String description;
    private int price; // Harga barang

    // Constructor
    public Item(int shippingWeight, String description, int price) {
        this.shippingWeight = shippingWeight;
        this.description = description;
        this.price = price;
    }

    // Methods
    public int getPriceForQuantity(int quantity) {
        return price * quantity;
    }

    public int getTax() {
        return price / 10; // Contoh: pajak 10% dari harga
    }

    public boolean inStock() {
        return true; // Contoh stok selalu tersedia
    }

    public int getShippingWeight() {
        return shippingWeight;
    }

    // Getter dan Setter untuk price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
