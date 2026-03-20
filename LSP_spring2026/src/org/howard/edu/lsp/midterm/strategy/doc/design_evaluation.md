The way the PriceCalculator class is set up makes it hard to extend or maintain. Right now, it uses a bunch of if statements to decide the discount based on customer type. This breaks the open/closed principle because any time we want to add a new customer type or discount rule, we have to go back and change the existing code.

It also doesn’t really take advantage of polymorphism. Instead of letting different classes handle different discount behaviors, it relies on conditional logic, which can get messy and harder to manage as the system grows.

On top of that, all the discount calculation logic is stuck in one method. That makes it tough to test individual discount behaviors on their own or reuse them somewhere else in the system.

Overall, this implementation isn’t very flexible or scalable. A better approach would be to separate each discount into its own class and use a design pattern like the Strategy Pattern to manage them.