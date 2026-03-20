package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a discount strategy to calculate final price.
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Sets the discount strategy.
     * 
     * @param strategy the discount strategy to use
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the selected strategy.
     * 
     * @param price original price
     * @return discounted price
     */
    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}