import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryStore {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new GroceryProduct("Black Label (1L)", 1339.00, 0));
        products.add(new GroceryProduct("Alfonso (1L)", 340.00, 0));
        products.add(new GroceryProduct("Jack Daniel (700ml)", 1249.00, 0));
        products.add(new GroceryProduct("Emperador Light (1L)", 300.00, 0));
        products.add(new GroceryProduct("Fundador Light (1L)", 490.00, 0));
        products.add(new GroceryProduct("Red Horse (1L)", 130.00, 0));
        products.add(new GroceryProduct("Pale Pilsen (Grande)", 90.00, 0));
        products.add(new GroceryProduct("San Mig Light (330ml)", 60.00, 0));
        products.add(new GroceryProduct("Heineken (330ml)", 90.00, 0));
        products.add(new GroceryProduct("Smirnoff Mule (330ml)", 70.00, 0));
        products.add(new GroceryProduct("Tiger Can (500ml)", 75.00, 0));
        




        Customer customer = new Customer("Joseph");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Liquor Store!");
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
                System.out.print(selectedProduct.getName() + " " +  "Enter quantity: ");
                int quantity = scanner.nextInt();
                customer.addToCart(selectedProduct, quantity);
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        customer.checkout();

    }
}
