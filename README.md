# Pertemuan 7

| Keterangan | Data                |
| ---------- | ------------------- |
| **Nama**   | Eky Fikri Yamansyah |
| **NIM**    | 312310572           |
| **Kelas**  | TI.23.A6            |

## Source Code
#### Class Customer :
```java
public class Customer {
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
#### Class Cash :
```java
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
```
#### Class Check :
```java
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
```
#### Class Creadit :
```java
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
```
####  Class Item :
```java
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
```
#### Class Order :
```java
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private List<OrderDetail> orderDetails;
    private Customer customer; // Tambahkan atribut Customer

    // Constructor
    public Order(Date date, String status, List<OrderDetail> orderDetails, Customer customer) {
        this.date = date;
        this.status = status;
        this.orderDetails = orderDetails;
        this.customer = customer;
    }

    // Methods
    public int calcSubTotal() {
        int subTotal = 0;
        for (OrderDetail detail : orderDetails) {
            subTotal += detail.calcSubTotal();
        }
        return subTotal;
    }

    public int calcTax() {
        int tax = 0;
        for (OrderDetail detail : orderDetails) {
            tax += detail.calcTax();
        }
        return tax;
    }

    public int calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public int calcTotalWeight() {
        int totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight();
        }
        return totalWeight;
    }

    // Getter untuk Customer
    public Customer getCustomer() {
        return customer;
    }
}
```
#### Class Order Detail :
```java
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
```
#### Class Payment :
```java
public abstract class Payment {
    protected int amount;

    public Payment(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
```
#### Class Main :
```java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Buat pelanggan
        Customer customer = new Customer("Rafi Ahmad", "123 Cibarusah");

        // Buat Item dengan harga yang dapat disesuaikan
        Item item1 = new Item(5, "Laptop", 15000000); // Berat: 5, Deskripsi: Item A, Harga: 20000
        Item item2 = new Item(3, "Item B", 15000); // Berat: 3, Deskripsi: Item B, Harga: 15000

        // Buat OrderDetail
        OrderDetail detail1 = new OrderDetail(2, "Taxable", item1); // Quantity: 2
        OrderDetail detail2 = new OrderDetail(1, "Taxable", item2); // Quantity: 1

        // Tambahkan OrderDetail ke dalam list
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(detail1);
        orderDetails.add(detail2);

        // Buat Order dengan Customer
        Order order = new Order(new Date(), "Pending", orderDetails, customer);

        // Tampilkan nama pelanggan
        System.out.println("Customer Name: " + order.getCustomer().getName());

        // Tampilkan hasil perhitungan
        System.out.println("Subtotal: " + order.calcSubTotal());
        System.out.println("Tax: " + order.calcTax());
        System.out.println("Total: " + order.calcTotal());
        System.out.println("Total Weight: " + order.calcTotalWeight());

        // Pembayaran menggunakan Cash
        Cash cash = new Cash(order.calcTotal(), 50000); // Total dibayar 50000
        System.out.println("Cash tendered: " + cash.getCashTendered());

        // Pembayaran menggunakan Check
        Check check = new Check(order.calcTotal(), "Rafi Ahmad", "12345");
        System.out.println("Check authorized: " + check.authorized());

        // Pembayaran menggunakan Credit
        Credit credit = new Credit(order.calcTotal(), "1234-5678-9876", "Visa", "12/25");
        System.out.println("Credit authorized: " + credit.authorized());
    }
}
```
#### Output :
![doc](Pertemuan11/output.png)
