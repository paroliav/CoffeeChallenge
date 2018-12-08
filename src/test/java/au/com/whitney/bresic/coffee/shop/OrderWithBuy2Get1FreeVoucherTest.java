package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.addons.Large;
import au.com.whitney.bresic.coffee.addons.Soy;
import au.com.whitney.bresic.coffee.beans.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderWithBuy2Get1FreeVoucherTest {

    Order order;

    @BeforeEach
    public void setUp() {
        order = new OrderWithBuy2Get1FreeVoucher();
    }

    @Test
    public void testCalculatedDiscountedTotal() {
        order.add(new Large(new Cappuccino()));
        order.add(new FlatWhite());

        assertEquals("$4", order.total());
    }

    @Test
    public void testCalculatedGST() {
        order.add(new Large(new Cappuccino()));
        order.add(new FlatWhite());

        assertEquals("$0.40", order.gst());
    }

    @Test
    public void testOrderingSingleCoffeeGivesNoDiscount(){
        order.add(new Espresso());

        assertEquals("$3", order.total());
        assertEquals("$0.30", order.gst());
    }

    @Test
    public void testOrderingSingleCoffeeWithAddOnGivesNoDiscount() {
        order.add(new Large(new Soy(new Cappuccino())));

        assertEquals("$4.50", order.total());
        assertEquals("$0.45", order.gst());
    }

    @Test
    public void testOrderingMoreThan2CoffeeGivesDiscount() {
        order.add(new Large(new Latte()));
        order.add(new Soy(new Large(new FlatWhite())));
        order.add(new Espresso());

        assertEquals("$8.50", order.total());
        assertEquals("$0.85", order.gst());
    }

    @Test
    public void testOrderingSameCoffeeTwiceGivesDiscount() {
        order.add(new Soy(new Latte()));
        order.add(new Soy(new Latte()));

        assertEquals("$4", order.total());
        assertEquals("$0.40", order.gst());
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
