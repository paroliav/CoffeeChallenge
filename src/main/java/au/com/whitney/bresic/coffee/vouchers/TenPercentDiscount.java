package au.com.whitney.bresic.coffee.vouchers;

import au.com.whitney.bresic.coffee.beans.Beverage;
import au.com.whitney.bresic.coffee.vouchers.Voucher;

import java.util.List;

public class TenPercentDiscount implements Voucher {

    public double calculateDiscount(List<Beverage> beverages) {
        double total = 0;
        for(Beverage beverage : beverages){
            total += beverage.cost();
        }
        return (.1 * total);
    }
}
