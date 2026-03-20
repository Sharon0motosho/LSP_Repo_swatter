package org.howard.edu.lsp.midterm.strategy;

/**
 * 10% discount for members.
 */
public class MemberDiscount implements DiscountStrategy {

    public double calculate(double price) {
        return price * 0.90;
    }
}