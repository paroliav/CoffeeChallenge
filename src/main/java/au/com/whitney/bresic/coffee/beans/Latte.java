package au.com.whitney.bresic.coffee.beans;

import au.com.whitney.bresic.coffee.annotations.Alterable;

@Alterable
public class Latte extends Beverage {
    public double cost() {
        return 3.50;
    }

}
