public class GroceryProduct extends Product {
    public GroceryProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayDetails() {
        System.out.println(getName() + " - $" + getPrice() + " per unit, Quantity: " + getQuantity());
    }
}
