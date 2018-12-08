package au.com.whitney.bresic.coffee.shop;

import au.com.whitney.bresic.coffee.beans.Beverage;
import au.com.whitney.bresic.coffee.vouchers.Voucher;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Order {

    private List<Beverage> beverages;
    private DecimalFormat formatter = new DecimalFormat("#0.##");
    private DecimalFormat formatterWithPadding = new DecimalFormat("#0.00");
    protected Voucher voucher;

    public Order() {
        beverages = new ArrayList<Beverage>();
    }

    public boolean add(Beverage beverage){
        return beverages.add(beverage);
    }

    public String total() {
        return "$"+format(calculateTotal());
    }

    private String format(double amount){
        String formattedAmount = formatter.format(amount);
        if(formattedAmount.contains(".")){
            return formatterWithPadding.format(amount);
        }
        return formattedAmount;
    }

    protected abstract double calculateTotal();

    public String gst() {
        return "$"+ format(.1 * calculateTotal());
    }

    public List<Beverage> getBeverages() {
        List<Beverage> copyOfBeverages = new ArrayList<Beverage>(beverages);
        return copyOfBeverages;
    }

}
