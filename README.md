# CoffeeChallenge

This is a Java-maven project written using only the JUnit framework and no other libraries are used to solve the Coffee challenge.

It handles adding a coffee to the order, getting the total and gst of the final order in a simple readable solution 

Problem Statement
------------------------

Build a solution to help coffee consumers order at a local cafe and calculate their expenditure.The solution should be able to add coffees to an order and calculate the total and gst (10% of total).


| Left-Aligned           | Center Aligned  | 
| :----------------------|:---------------:| 
| Regular Espresso       | $3              | 
| Regular Cappuccino     | $3.50           |  
| Regular Latte          | $3.50           |
| Regular Flat white     | $3.50           |
| Soy Flat White         | $4.00           |
| Large Soy Flat White   | $4.50           |

Large coffee costs 50c more than regular. Soy also costs 50c more. Espresso only comes in one size.

Example code

```Java
order.add(coffee1) 
order.add(coffee2) 
order.add(coffee3) 
order.total() 
order.gst()
```
####Example scenario:

When my order has the following coffees then expected result is below

```
espresso
large cappuccino 
soy flat white 
cappuccino

Expected result:
order.total() = $14.50 
order.gst() = $1.45
```

###Optional extra (time permitting)


If you want to continue proceed with applying vouchers below:
The local cafe also allows consumers to apply a voucher and receive a discount. 
The possible vouchers are 10% discount or 2 for 1 where the cheapest coffee is free. Adjust the total to apply these discounts.

####Example scenario with 10% off voucher:
When my order has the following coffees and 10% off voucher then expected result is below
```
cappuccino large 
soy flat white

Expected result:

order.total() = $7.20 
order.gst() = $0.72
```

####Example scenario with 2 for 1 voucher:
When my order has the following coffees and a 2 for 1 voucher then expected result is below

```
cappuccino large 
flat white

Expected result:

order.total() = $4 
order.gst() = $0.40
```

Solution
-------------

Written in Java, this solution aims to handle the decoration of basic coffee types by use of AddOns

The Coffee beans folder has all the Java POJO objects to create base coffee types

Coffee shop has different order type

1) Order sans voucher
2) Order with 10% discount voucher
3) Order with buy 2 get 1 free voucher

Voucher has the variation of vouchers

##Tests

All the test cases handling various scenarios are written in tests folder using the JUnit test framework

Some of the test cases handled are

- Mentioned in the problem statement
- Check Espresso can not be decorated
- Allow ordering with vouchers
- Total for empty order
- Buy 2 get 1 free voucher for an order with single coffee

All the test cases are running and passing. 
