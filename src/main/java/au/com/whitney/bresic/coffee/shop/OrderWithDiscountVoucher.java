package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.beans.Beverage;
import au.com.whitney.bresic.coffee.vouchers.TenPercentDiscount;

public class OrderWithDiscountVoucher extends Order{

    public  OrderWithDiscountVoucher() {
        voucher = new TenPercentDiscount();
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
