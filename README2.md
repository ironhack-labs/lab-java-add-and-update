1. Did you use the same type of route to update patient information as to update an employee's department?

Yes, I used PUT for both.
2. Why did you choose the selected strategy?

PUT is straightforward for full updates and ensures idempotency, meaning repeated requests have the same effect.
3. What are the advantages and disadvantages of the strategies you chose for creating these routes?

   Advantages:
   Idempotency: Ensures consistent outcomes.
   Simplicity: Easy to implement and understand.
   Disadvantages:
   Inefficiency: Requires sending the entire resource, even for small updates.
   Risk of Overwriting: Potential to overwrite unintended fields.

4. What is the cost-benefit between using PUT and PATCH?

   PUT:
   Cost: Inefficient for partial updates, risk of overwriting.
   Benefit: Simple, idempotent, good for full updates.
   PATCH:
   Cost: Slightly more complex to implement.
   Benefit: Efficient for partial updates, reduces unnecessary data transfer