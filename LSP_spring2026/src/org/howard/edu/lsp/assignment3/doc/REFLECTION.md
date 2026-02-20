# Assignment 3 Reflection 
Sharon Omotosho CSCI 363 


## Introduction 
 In Assignment 2, I implemented an ETL pipeline in Java using a largely procedural design. While the program correctly read data from `data/products.csv`, applied the required transformations, and produced `data/transformed_products.csv`, all responsibilities were contained within a single class and primarily inside the `main` method. The structure worked functionally, but it did not clearly reflect object-oriented principles. 
 For Assignment 3, I redesigned the same program to be more object-oriented while keeping the exact same behavior, transformations, error handling, summary output, and relative file paths. The goal was not to change functionality, but to improve structure, modularity, and clarity.
  
## Design Differences Between Assignment 2 and Assignment 3
  In Assignment 2: 
 	- File reading, parsing, validation, transformation logic, writing output, and summary printing were all inside one class. 
	- Product data was handled as raw variables extracted from a `String[]`.
	- There was no explicit representation of a product as an object. 
 In Assignment 3:
	- The program is decomposed into three classes:
		- `Product` 
		- `ProductTransformer` 
		- `ProductETLProcessor` 
	- Each class has a clear responsibility. 
	- Product data is represented as an object rather than a collection of temporary variables. This redesign 	improves readability and makes the structure easier to understand and extend. 
	
## Object-Oriented Concepts Used
### 1. Classes and Objects 
 Assignment 3 introduces a dedicated `Product` class to represent each row of input data. Instead of manipulating primitive values directly, the program now creates a `Product` object for each valid row: 
 ```java
  Product product = new Product(id, name, price, category); 
This models the real-world concept of a product and improves clarity. 

### 2. Encapsulation 
The Product class uses private fields:
 private int productId; 
 private String name;
 private BigDecimal price;
 private String category;
 private String priceRange; 
These fields cannot be accessed directly from outside the class. Instead, getters and setters are used. This protects internal state and ensures controlled access to data. In Assignment 2, product values were freely modified inside the main method. Assignment 3 improves this by encapsulating state within the object. 

###3. Abstraction 
In Assignment 2, the transformation logic (upper case conversion, discount calculation, premium category update, price range classification) was embedded directly in the ETL logic. 
In Assignment 3, transformation rules were moved into the ProductTransformer class. The ETL processor now simply calls: transformer.transform(product); 
This abstracts transformation behavior from file processing logic. The ETL processor does not need to know how transformations work internally—it only delegates the task. 

###4. Improved Separation of Concerns 
Each class now has a single responsibility: 
	Product: stores and represents product data. 
	ProductTransformer: applies business rules. 
	ProductETLProcessor: handles file I/O, validation, and 	orchestration. 
This makes the program easier to maintain and reason about compared to the monolithic structure in Assignment 2. 

##Maintaining Identical Behavior 
 A key requirement of this assignment was that Assignment 3 must produce the exact same outputs and handle errors the same way as Assignment 2. 
To verify correctness, I: 
1. Ran both versions using the same products.csv file. 
	2. Compared the resulting transformed_products.csv files line by line. 
	3.Verified: 
		-Product names were converted to upper case. 
		-Electronics received a 10% discount. 
		-Premium Electronics category logic worked identically. 
		-Price ranges (Low, Medium, High, Premium) were 		classified the same. 
		-Summary statistics matched. 
	4.Tested edge cases:
		-Missing input file (verified error message).
		-Empty input file (verified summary output). 
		-Rows with invalid format or number parsing errors 		(verified skipped row count). 
Both implementations produced identical output and behavior. 

##Use of Generative AI 
 I used chatGPT to brainstorm how to restructure my procedural solution into a more object-oriented design. ChatGPT suggested introducing: 
	-A Product class to model product data. 
	-A separate transformation class. 
	-Clear separation of responsibilities.
	- Maintaining relative paths instead of absolute paths. 
 I did not adopt every suggestion exactly as given. For example, an earlier suggestion included creating four classes, but I adjusted the design to use exactly three classes to match the assignment structure. I reviewed and edited all generated code and documentation to ensure correctness, compliance with course requirements, and consistency with my original functionality. 
 
##Conclusion 
 Assignment 3 significantly improves the structure and clarity of my ETL pipeline while preserving its functionality. Compared to Assignment 2, the redesigned version demonstrates stronger use of object-oriented principles, including encapsulation, abstraction, and separation of concerns. The final implementation is more modular, more readable, and easier to extend in the future, while still meeting all original requirements exactly