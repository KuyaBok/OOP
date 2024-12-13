import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryStore {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new GroceryProduct("Apple", 1.0, 0));
        products.add(new GroceryProduct("Banana", 0.5, 0));
        products.add(new GroceryProduct("Orange", 1.5, 0));

        Customer customer = new Customer("Alice");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grocery Store!");
        boolean shopping = true;

        while (shopping) {
            System.out.println("\nAvailable products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.print((i + 1) + ". ");
                products.get(i).displayDetails();
            }

            System.out.print("\nSelect a product by number (or 0 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                shopping = false;
                break;
            } else if (choice > 0 && choice <= products.size()) {
                Product selectedProduct = products.get(choice - 1);
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                customer.addToCart(selectedProduct, quantity);
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        customer.checkout();

    }
}
