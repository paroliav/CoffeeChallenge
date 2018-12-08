package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.addons.Large;
import au.com.whitney.bresic.coffee.addons.Soy;
import au.com.whitney.bresic.coffee.beans.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    Order order;

    @BeforeEach
    public void setUp() {
        order = new OrderSansVoucher();
    }

    @Test
    public void testOrderTotal() {
        order.add(new Espresso());
        order.add(new Large(new Cappuccino()));
        order.add(new Soy(new FlatWhite()));
        order.add(new Cappuccino());

        assertEquals("$14.50", order.total());
    }

    @Test
    public void testOrderGST() {
        order.add(new Espresso());
        order.add(new Large(new Cappuccino()));
        order.add(new Soy(new FlatWhite()));
        order.add(new Cappuccino());

        assertEquals("$1.45", order.gst());
    }

    @Test
    public void testAddingALargeExpressoThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            order.add(new Large(new Espresso()));
        });

    }

    @Test
    public void testAddingASoyExpressoThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            order.add(new Soy(new Espresso()));
        });

    }

    @Test
    public void testAddingALargeSoyExpressoThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            order.add(new Large(new Soy(new Espresso())));
        });

    }

    @Test
    public void testOrderTotalForEspresso() {
        order.add(new Espresso());

        assertEquals("$3", order.total());
        assertEquals("$0.30", order.gst());
    }

    @Test
    public void testOrderTotalForCappuccino() {
        order.add(new Cappuccino());

        assertEquals("$3.50", order.total());
        assertEquals("$0.35", order.gst());
    }

    @Test
    public void testOrderTotalForFlatWhite() {
        order.add(new FlatWhite());

        assertEquals("$3.50", order.total());
        assertEquals("$0.35", order.gst());
    }

    @Test
    public void testOrderTotalForLatte() {
        order.add(new Latte());

        assertEquals("$3.50", order.total());
        assertEquals("$0.35", order.gst());
    }

    @Test
    public void testEmptyOrder() {
        assertEquals("$0", order.total());
        assertEquals("$0", order.gst());
    }


    @AfterEach
    public void tearDown(){
        order = null;
    }

}
