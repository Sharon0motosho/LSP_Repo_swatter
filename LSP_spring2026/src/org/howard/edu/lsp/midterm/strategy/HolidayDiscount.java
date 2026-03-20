package org.howard.edu.lsp.midterm.strategy;

/**
 * 15% discount for holiday customers.
 */
public class HolidayDiscount implements DiscountStrategy {

    public double calculate(double price) {
        return price * 0.85;
    }
}