package org.howard.edu.lsp.midterm.strategy;

/**
 * 20% discount for VIP customers.
 */
public class VIPDiscount implements DiscountStrategy {

    public double calculate(double price) {
        return price * 0.80;
    }
}
