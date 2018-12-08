package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.beans.Beverage;

public class OrderSansVoucher extends Order {

    protected double calculateTotal(){
        double total = 0;
        for(Beverage beverage : getBeverages()){
            total += beverage.cost();
        }
        return total;
    }

}
