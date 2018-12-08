package au.com.whitney.bresic.coffee.vouchers;

import au.com.whitney.bresic.coffee.beans.Beverage;
import au.com.whitney.bresic.coffee.vouchers.Voucher;

import java.util.List;

public class Buy2Get1Free implements Voucher {

    public double calculateDiscount(List<Beverage> beverages) {
        if(beverages. size() > 1){
            return cheapestBeverage(beverages);
        }
        return 0;
    }

    private double cheapestBeverage(List<Beverage> beverages) {
        double cheapest = beverages.get(0).cost();
        beverages.remove(0);
        for(Beverage beverage : beverages) {
            if(cheapest > beverage.cost()){
                cheapest = beverage.cost();
            }
        }
        return cheapest;
    }

}
