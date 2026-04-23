The Template Method pattern is implemented in the Report class using generateReport() as the fixed workflow.
The steps (loadData, formatHeader, formatBody, formatFooter) are defined as abstract methods and overridden by subclasses.
StudentReport and CourseReport provide their own implementations for each step, allowing variation in behavior.
Polymorphism is demonstrated by storing both reports in a List<Report> and calling generateReport() on each.
This design improves maintainability by enforcing a consistent structure while allowing flexible customization.