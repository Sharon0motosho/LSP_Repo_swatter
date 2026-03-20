Prompt:

Evaluate an OrderProcessor class for OO design issues and redesign it using CRC cards.
The following class is part of a simple order processing system. The design of this class violates several object-oriented design ideas discussed in class, including principles described in Arthur Riel’s object-oriented design heuristics. Study the code carefully and answer the questions that follow.
Provided Class

import java.io.FileWriter;
import java.util.Date;

public class OrderProcessor {

    // Order data (poor encapsulation)
    public String customerName;
    public String email;
    public String item;
    public double price;

    public void processOrder() {

        // calculate tax
        double tax = price * 0.07;
        double total = price + tax;

        // print receipt
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + item);
        System.out.println("Total: " + total);

        // save order to file
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            writer.write(customerName + "," + item + "," + total + "\n");
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // send confirmation email
        System.out.println("Sending confirmation email to " + email);

        // apply discount
        if(price > 500) {
            total = total * 0.9;
        }

        // log activity
        System.out.println("Order processed at " + new Date());
    }
}


Response:

This is a classic “bad OO design” example — your professor definitely expects you to identify the issues clearly and then break it into proper CRC cards.

I’ll structure this in a way you can directly submit (clean, student-style, not robotic).

✅ 1. OO Design Issues in OrderProcessor

The class violates several object-oriented design principles:

🔴 1. Poor Encapsulation

All fields (customerName, email, item, price) are public

Any part of the program can modify them directly
👉 Violates information hiding

🔴 2. Too Many Responsibilities (Low Cohesion)

The class is doing way too much:

Calculates tax

Applies discount

Prints receipt

Writes to file

Sends email

Logs activity

👉 This violates the Single Responsibility Principle
👉 According to Riel: “A class should have a single, well-defined purpose”

🔴 3. Tight Coupling

Directly uses FileWriter

Hardcoded file name "orders.txt"

Email logic is embedded inside

👉 Makes the class hard to modify or reuse

🔴 4. No Separation of Concerns

Business logic + I/O + logging are all mixed together:

Calculation logic

File handling

Output formatting

👉 These should be separate classes

🔴 5. Poor Reusability

You cannot reuse:

tax calculation

discount logic

email sending
independently

🔴 6. Hardcoded Values

Tax rate = 0.07

Discount rule = price > 500

File name = "orders.txt"

👉 Not flexible or configurable

✅ 2. Improved CRC Card Design

We break the system into smaller, focused classes.

🟦 CRC Card 1: Order

Class: Order
Responsibilities:

store order data (customer, email, item, price)

provide order details

calculate total price (including tax and discount)

Collaborators:

TaxCalculator

DiscountCalculator

🟦 CRC Card 2: TaxCalculator

Class: TaxCalculator
Responsibilities:

calculate tax for an order

Collaborators:

Order

🟦 CRC Card 3: DiscountCalculator

Class: DiscountCalculator
Responsibilities:

apply discount rules to an order

Collaborators:

Order

🟦 CRC Card 4: ReceiptPrinter

Class: ReceiptPrinter
Responsibilities:

format and print receipt information

Collaborators:

Order

🟦 CRC Card 5: OrderRepository

Class: OrderRepository
Responsibilities:

save order data to file

Collaborators:

Order

🟦 CRC Card 6: EmailService

Class: EmailService
Responsibilities:

send confirmation emails to customers

Collaborators:

Order

🟦 CRC Card 7: Logger

Class: Logger
Responsibilities:

log order processing activity

Collaborators:

none

🟦 CRC Card 8: OrderProcessor (Redesigned)

Class: OrderProcessor
Responsibilities:

coordinate order processing workflow

delegate tasks to appropriate classes

Collaborators:

Order

TaxCalculator

DiscountCalculator

ReceiptPrinter

OrderRepository

EmailService

Logger

✅ 3. Why This Design Is Better
✔ High Cohesion

Each class has one clear responsibility

✔ Low Coupling

Classes interact through clear interfaces, not direct implementation details

✔ Better Encapsulation

Order data is stored in one place, not spread everywhere

✔ Reusability

Tax logic can be reused

Email service can be reused

File storage can be swapped out

✔ Flexibility

Change tax rate → only TaxCalculator

Change discount rules → only DiscountCalculator

Change storage → only OrderRepository


How it helped:
This helped me understand how to break a large class into smaller, well-defined classes and distribute responsibilities properly according to object-oriented design principles.