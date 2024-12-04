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
