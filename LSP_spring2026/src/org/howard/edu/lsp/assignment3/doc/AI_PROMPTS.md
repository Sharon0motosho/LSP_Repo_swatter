# AI Prompts Used for Assignment 3
Sharon Omotosho CSCI 363 

Below are the actual prompts I used while redesigning my Assignment 2 ETL pipeline into a more object-oriented implementation.
 
## Prompt 1 
"this is my old code:
 [Full Assignment 2 ETLPipeline.java pasted] 
these are the requirements i need you to follow:
 CSCI 363 – Assignment 3: Object-Oriented Redesign of Your ETL Pipeline [Full assignment instructions pasted]" 
 
### How I Used This
 I provided my complete Assignment 2 code and the full Assignment 3 requirements. The AI suggested decomposing the single-class design into multiple classes, separating data representation from transformation logic. I used this to plan the structure of my new implementation.  
 
 
## Prompt 2 
"remember this is all there should be:
 ├── <YourClass1>.java
 ├── <YourClass2>.java 
 ├── <YourClass3>.java 
 └── doc/ 
 	├── REFLECTION.md 
 	└── AI_PROMPTS.md" 

### How I Used This 
ChatGPT initially suggested four classes. I clarified that the assignment example shows exactly three classes. Based on this, I adjusted the design to include only three public classes: - Product - ProductTransformer - ProductETLProcessor --- 

## Prompt 3
"i need a name that is not etlpipeline for the class" 
### How I Used This 
ChatGPTsuggested several alternatives. I selected a clearer, more descriptive name for the main class to better reflect its responsibility and distinguish it from Assignment 2.
