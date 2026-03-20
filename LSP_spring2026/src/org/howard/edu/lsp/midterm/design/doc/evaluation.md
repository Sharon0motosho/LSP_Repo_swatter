The OrderProcessor class has a bunch of design issues that go against basic object-oriented principles. First, encapsulation is weak because all the data fields (customerName, email, item, price) are public. That means any other class can change them directly, which can mess up the data and break consistency.

Another big problem is that it violates the single responsibility principle. The processOrder() method is doing way too much—it’s calculating totals, printing output, writing to a file, sending emails, applying discounts, and logging everything. Each class should really have one clear job, but this one is trying to do everything at once.

The class is also tightly tied to specific implementations like FileWriter and console output. That makes it harder to change or extend. For instance, if we wanted to save orders in a database instead of a file, we’d have to rewrite this class.

On top of that, the discount logic is hardcoded with an if statement, which makes it tricky to add new discount types. Every time we add a new rule, we’d have to go back and change the method, which breaks the open/closed principle.

Overall, this design hurts maintainability and scalability. Responsibilities aren’t well separated, and the class ends up being a “god class” trying to do too much.