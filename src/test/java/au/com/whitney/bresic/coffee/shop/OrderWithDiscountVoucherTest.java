package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.addons.Large;
import au.com.whitney.bresic.coffee.addons.Soy;
import au.com.whitney.bresic.coffee.beans.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderWithDiscountVoucherTest {

    Order order;

    @BeforeEach
    public void setUp() {
        order = new OrderWithDiscountVoucher();
    }

    @Test
    public void testCalculatedDiscountedTotal() {
        order.add(new Large(new Cappuccino()));
        order.add(new Soy(new FlatWhite()));

        assertEquals("$7.20", order.total());
    }

    @Test
    public void testCalculatedGST() {
        order.add(new Large(new Cappuccino()));
        order.add(new Soy(new FlatWhite()));

        assertEquals("$0.72", order.gst());
    }

    @Test
    public void testOrdering1CoffeeGivesDiscount() {
        order.add(new Espresso());

        assertEquals("$2.70", order.total());
        assertEquals("$0.27", order.gst());
    }

    @Test
    public void testOrderingSameCoffeeTwiceGivesDiscount() {
        order.add(new Large(new Latte()));
        order.add(new Large(new Latte()));

        assertEquals("$7.20", order.total());
        assertEquals("$0.72", order.gst());
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
