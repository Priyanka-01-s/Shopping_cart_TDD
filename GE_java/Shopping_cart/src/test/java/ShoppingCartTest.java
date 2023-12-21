import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.Item;
import com.example.ShoppingCart;

public class ShoppingCartTest {
    
    //Test creating an item with valid details.●Test getting item details.
    @Test
    public void testCreateItem() {
        int itemId = 1;
        String itemName = "Dress";
        double itemPrice = 1299.00;

        Item item = new Item(itemId, itemName, itemPrice);

        assertEquals(itemId, item.getId());
        assertEquals(itemName, item.getName());
        assertEquals(itemPrice, item.getPrice());
    }

    //●Test adding items to the cart.
    @Test
    public void testAddingItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item(1, "Pen", 59.00);
        Item item2 = new Item(2, "Notebook", 90.00);
        Item item3 = new Item(3, "Pencil", 10.00);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.addItem(item3);

        assertEquals(3, shoppingCart.getItems().size());
        assertTrue(shoppingCart.getItems().contains(item1));
        assertTrue(shoppingCart.getItems().contains(item2));
        assertTrue(shoppingCart.getItems().contains(item3));
    }

    //●Test removing items from the cart.
    @Test
    public void testRemmovingItems(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item = new Item(1, "Milk", 100.00);

        shoppingCart.addItem(item);
        shoppingCart.removeItem(item);

        assertEquals(0, shoppingCart.getItems().size());
        assertFalse(shoppingCart.getItems().contains(item));

    }

    //●Test viewing items in the cart.
    @Test
    public void viewItems(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item(1, "Tea", 150.00);
        Item item2 = new Item(1, "Coffee", 200.00);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        assertEquals(2, shoppingCart.getItems().size());
        assertTrue(shoppingCart.getItems().contains(item1));
        assertTrue(shoppingCart.getItems().contains(item2));
    }

    //●Test calculating the total price of items in the cart.
    @Test
    public void testCalculateTotalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item(1, "Laptop", 20000.00);
        Item item2 = new Item(2, "Mouse", 2500.00);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        double totalPrice = shoppingCart.calculateTotalPrice();

        assertEquals(22500.00, totalPrice);
    }
}
