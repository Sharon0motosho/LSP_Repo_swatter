package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for discount strategies.
 * Defines how price should be calculated.
 * 
 * @author Sharon
 */
public interface DiscountStrategy {
    double calculate(double price);
}

