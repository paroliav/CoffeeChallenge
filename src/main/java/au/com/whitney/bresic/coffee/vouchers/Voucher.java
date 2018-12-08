package au.com.whitney.bresic.coffee.vouchers;

import au.com.whitney.bresic.coffee.beans.Beverage;

import java.util.List;

public interface Voucher {

    double calculateDiscount(List<Beverage> beverages);
}
