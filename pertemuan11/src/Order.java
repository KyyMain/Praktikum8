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
