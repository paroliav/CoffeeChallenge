package au.com.whitney.bresic.coffee.addons;

import au.com.whitney.bresic.coffee.annotations.Alterable;
import au.com.whitney.bresic.coffee.beans.Beverage;

public class Soy extends AddOn {

    Beverage beverage;

    public Soy(Beverage beverage){
        if(beverage.getClass().getAnnotation(Alterable.class) != null && beverage.getClass().getAnnotation(Alterable.class).isAlterable()){
            this.beverage = beverage;
        } else {
            throw new RuntimeException("This beverage is not available with Soy");
        }
    }

    public double cost() {
        return .5 + beverage.cost();
    }

}
