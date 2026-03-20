prompt:
Refactor a PriceCalculator class using the Strategy Pattern and provide full implementation.
Provided Class

package org.howard.edu.lsp.midterm.strategy;

public class PriceCalculator {

    public double calculatePrice(String customerType, double price) {

        double finalPrice = price;

        if (customerType.equals("REGULAR")) {
            finalPrice = price;
        }

        if (customerType.equals("MEMBER")) {
            finalPrice = price * 0.90;
        }

        if (customerType.equals("VIP")) {
            finalPrice = price * 0.80;
        }

        if (customerType.equals("HOLIDAY")) {
            finalPrice = price * 0.85;
        }

        return finalPrice;
    }
}


response:
Perfect — this is a classic scenario for the Strategy Pattern, because pricing logic varies by customer type and can change independently. Right now, the PriceCalculator is tightly coupled with if statements, which violates the Open/Closed Principle.

Let’s refactor it using the Strategy Pattern.

✅ 1. Step 1 – Define a Price Strategy Interface
package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for calculating price based on customer type.
 */
public interface PriceStrategy {
    double calculatePrice(double price);
}
✅ 2. Step 2 – Implement Concrete Strategies
package org.howard.edu.lsp.midterm.strategy;

/** Regular customer: no discount */
public class RegularPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}

package org.howard.edu.lsp.midterm.strategy;

/** Member customer: 10% discount */
public class MemberPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
package org.howard.edu.lsp.midterm.strategy;

/** VIP customer: 20% discount */
public class VIPPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
package org.howard.edu.lsp.midterm.strategy;

/** Holiday special discount: 15% off */
public class HolidayPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
✅ 3. Step 3 – Refactor PriceCalculator to Use Strategy
package org.howard.edu.lsp.midterm.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * PriceCalculator delegates calculation to the appropriate strategy.
 */
public class PriceCalculator {

    private Map<String, PriceStrategy> strategies;

    public PriceCalculator() {
        strategies = new HashMap<>();
        strategies.put("REGULAR", new RegularPriceStrategy());
        strategies.put("MEMBER", new MemberPriceStrategy());
        strategies.put("VIP", new VIPPriceStrategy());
        strategies.put("HOLIDAY", new HolidayPriceStrategy());
    }

    /**
     * Calculates final price based on customer type.
     *
     * @param customerType type of customer (REGULAR, MEMBER, VIP, HOLIDAY)
     * @param price        base price
     * @return final price after applying discount
     */
    public double calculatePrice(String customerType, double price) {
        PriceStrategy strategy = strategies.get(customerType.toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown customer type: " + customerType);
        }
        return strategy.calculatePrice(price);
    }
}
✅ 4. Step 4 – Example Usage
package org.howard.edu.lsp.midterm.strategy;

public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        System.out.println("REGULAR: " + calculator.calculatePrice("REGULAR", 100));
        System.out.println("MEMBER: " + calculator.calculatePrice("MEMBER", 100));
        System.out.println("VIP: " + calculator.calculatePrice("VIP", 100));
        System.out.println("HOLIDAY: " + calculator.calculatePrice("HOLIDAY", 100));
    }
}

Output:

REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
✅ 5. Why This Is Better

Open/Closed Principle:
Adding a new customer type only requires creating a new PriceStrategy class — no need to touch PriceCalculator.

Low Coupling:
PriceCalculator no longer contains multiple if statements.

High Cohesion:
Each strategy is focused on a single calculation.

Easier Testing:
Each strategy can be tested independently.


How it helped:
This helped me understand how to replace conditional logic with polymorphism and design a more flexible and maintainable system.