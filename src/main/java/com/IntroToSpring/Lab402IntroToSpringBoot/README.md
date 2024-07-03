1. Did you use the same type of route to update patient information as to update an employee's department?
   
Yes, I used the `PUT` method for both routes. This method is typically used for updates where you provide the entire entity to be updated.

2. Why did you choose the selected strategy?

Using the `PUT` method for updates ensures that the entire entity is replaced or updated with the provided information. It is a common convention for update operations and helps maintain consistency in API design.

3. What are the advantages and disadvantages of the strategies you chose for creating these routes?
- Consistency in API design by using `PUT` for updates.
- Clear and predictable behavior for clients using the API.
- Easy to implement and understand.

**Disadvantages:**
- `PUT` requires sending the entire entity, which can be less efficient if only a small part of the entity needs to be updated.
- Potential for overwriting data if not handled carefully.

4. What is the cost-benefit between using PUT and PATCH?
   Cost-Benefit of PUT vs. PATCH:

PUT: Simpler but riskier if partial updates are frequent.
PATCH: More complex but allows for targeted updates to specific fields.
Choosing PUT here prioritizes simplicity as updates likely involve most, if not all, patient or department information.

Remember to replace Patient with your actual patient model class and implement logic in the service layer to handle data persistence.