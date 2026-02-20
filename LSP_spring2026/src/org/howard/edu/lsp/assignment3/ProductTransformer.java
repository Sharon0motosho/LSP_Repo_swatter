package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Responsible for applying transformation rules
 * to Product objects.
 */
public class ProductTransformer {

    /**
     * Applies all required transformations to a product.
     *
     * @param product the product to transform
     */
    public void transform(Product product) {

        // Convert name to uppercase
        product.setName(product.getName().toUpperCase());

        boolean isElectronics = product.getCategory().equals("Electronics");
        BigDecimal price = product.getPrice();

        // Apply 10% discount for Electronics
        if (isElectronics) {
            price = price.multiply(new BigDecimal("0.90"));
        }

        price = price.setScale(2, RoundingMode.HALF_UP);
        product.setPrice(price);

        // Update category if Premium Electronics
        if (isElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
            product.setCategory("Premium Electronics");
        }

        // Determine price range
        String priceRange;

        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }

        product.setPriceRange(priceRange);
    }
}