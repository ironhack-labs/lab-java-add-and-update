
1. In your `README.md`, write a short answer to the following questions:

  Question  - Did you use the same type of route to update patient information as to update an employee's department?
Answer -  You may use either PUT or PATCH for  updating patient information and updating an employee's department.
  PUT is more suitable if you expect to update all fields of a resource, while PATCH is used for partial updates.
- Question : Why did you choose the selected strategy?
- Answer: Choose PATCH if you want more flexibility and partial updates, or PUT if you prefer a stricter approach where the 
          entire resource is updated. For simplicity, PATCH is generally more versatile in real-world applications.
- Question: What are the advantages and disadvantages of the strategies you chose for creating these routes?
- Answer:  Advantages and Disadvantages:

PUT:
Advantage: Enforces consistency by expecting the entire resource.
Disadvantage: More data may be required, even if only a single field needs updating.
PATCH:
Advantage: Ideal for partial updates, reducing the amount of data needed.
Disadvantage: Can lead to inconsistent state if partial updates are not carefully managed.

- Question:What is the cost-benefit between using `PUT` and `PATCH`? 
  - Answer: 
     PUT is beneficial when you want to enforce the entire resource's state and ensure all fields are updated at once, 
     which could prevent unintended data inconsistencies. 
     However, it may be less efficient if only a small change is required. 
     PATCH is more efficient for partial updates but requires careful handling to avoid leaving certain fields in an unintended state.






