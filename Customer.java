import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private List<Product> cart;

    public Customer() {
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        product.setQuantity(quantity);
        cart.add(product);
        System.out.println(quantity + " " + product.getName() + " added to cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void checkout() {
        double total = calculateTotal();
        System.out.println("Total cost: Php" + total);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: Php");
        double payment = scanner.nextDouble();

        if (payment >= total) {
            System.out.println("Payment successful! Change: Php" + (payment - total));
        } else {
            System.out.println("Insufficient payment. Please try again.");
        }
    }
}
