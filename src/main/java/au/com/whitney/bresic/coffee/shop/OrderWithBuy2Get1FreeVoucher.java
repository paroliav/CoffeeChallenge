package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.beans.Beverage;
import au.com.whitney.bresic.coffee.vouchers.Buy2Get1Free;

public class OrderWithBuy2Get1FreeVoucher extends Order {

    public OrderWithBuy2Get1FreeVoucher() {
        voucher = new Buy2Get1Free();
    }

    protected double calculateTotal() {
        double total = 0;
        for(Beverage beverage : getBeverages()){
            total += beverage.cost();
        }
        return total - getVoucherDiscount();
    }

    protected double getVoucherDiscount() {
        return voucher.calculateDiscount(getBeverages());
    }

}
