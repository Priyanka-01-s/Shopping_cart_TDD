import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.Test;

import com.example.Item;
import com.example.ShoppingCart;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Item laptop;
    private Item mouse;
    private Item keyboard;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        laptop = new Item(1, "Laptop", 30000.00);
        mouse = new Item(2, "Mouse", 5000.00);
        keyboard = new Item(3, "Keyboard", 7500.00);
    }

    @Test
    public void testAddItemToCart() {
        cart.addItem(laptop, 2);
        cart.addItem(mouse, 3);
        cart.addItem(keyboard, 1);

        assertEquals(3, cart.getCartItems().size());
        assertEquals(2, cart.getCartItems().get(laptop));
        assertEquals(3, cart.getCartItems().get(mouse));
        assertEquals(1, cart.getCartItems().get(keyboard));
    }

    @Test
    public void testRemoveItemFromCart() {
        cart.addItem(laptop, 2);
        cart.addItem(mouse, 3);

        cart.removeItem(laptop, 1);

        assertEquals(2, cart.getCartItems().size());
        assertEquals(1, cart.getCartItems().get(laptop));
        assertEquals(3, cart.getCartItems().get(mouse));

        cart.removeItem(laptop, 1);
        cart.removeItem(mouse, 3);

        assertEquals(0, cart.getCartItems().size());
        assertFalse(cart.getCartItems().containsKey(laptop));
        assertFalse(cart.getCartItems().containsKey(mouse));
    }

    @Test
    public void testViewItemsInCart() {
        cart.addItem(laptop, 2);
        cart.addItem(mouse, 3);

        assertEquals(2, cart.getCartItems().size());
        assertEquals(2, cart.getCartItems().get(laptop));
        assertEquals(3, cart.getCartItems().get(mouse));
    }

    @Test
    public void testCalculateTotalPrice() {
        cart.addItem(laptop, 2);
        cart.addItem(mouse, 3);

        double totalPrice = cart.calculateTotalPrice();

        assertEquals(2 * laptop.getPrice() + 3 * mouse.getPrice(), totalPrice, 0.01);
    }
}