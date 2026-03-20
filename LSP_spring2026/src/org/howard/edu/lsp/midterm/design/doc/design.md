#####Class: Order

Responsibilities:
- store customer name, email, item, and price information
- provide access to order details for processing components
- allow retrieval of price and customer data when needed

Collaborators:
none

#####Class: OrderProcessor

Responsibilities:
- coordinate the overall order processing workflow
- retrieve order data and pass it to processing components
- invoke tax calculation and discount application
- trigger receipt generation, order storage, and logging

Collaborators:
Order, TaxCalculator, DiscountStrategy, ReceiptPrinter, OrderRepository, EmailService, Logger

#####Class: TaxCalculator
Responsibilities:
- compute tax based on the order price and applicable tax rate
- return calculated tax value to OrderProcessor

Collaborators:
Order

#####Class: DiscountStrategy

Responsibilities:
- apply discount rules based on order conditions (e.g., price threshold)
- compute and return the discounted total amount

Collaborators:
Order

#####Class: ReceiptPrinter

Responsibilities:
- format and display receipt details including customer, item, and total price
- retrieve order information to generate readable output

Collaborators:
Order

#####Class: OrderRepository

Responsibilities:
- persist order data to a storage medium (e.g., file or database)
- format order information for storage

Collaborators:
Order

#####Class: EmailService

Responsibilities:
- send confirmation email to the customer using their email address
- retrieve customer contact information from the order

Collaborators:
Order

#####Class: Logger

Responsibilities:
- record order processing activity and timestamps
- log system events for tracking and debugging purposes

Collaborators:
none