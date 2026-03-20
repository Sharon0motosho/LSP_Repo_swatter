package org.howard.edu.lsp.midterm.strategy;

/**
 * No discount for regular customers.
 */
public class RegularDiscount implements DiscountStrategy {

    public double calculate(double price) {
        return price;
    }
}