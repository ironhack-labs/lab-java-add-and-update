6. **Write a short answer in README.md**.

### Did you use the same type of route to update patient information as to update an employee's department?  
- No. To update all the information of a patient, I used `@PutMapping("/{patientId}")`, and for updating only the employee's department I, used `@PatchMapping("/department/{employeeId}")`.  

### Why did you choose the selected strategy?  
- To improve flexibility by using specific route and preventing unnecessary field validations.

### What are the advantages and disadvantages of the strategies you chose for creating these routes?  

**Advantages:**
- Validation is applied only to the specific fields.
- Partial updates reduce data transfer.

**Disadvantages:**
- You need to clearly specify the type of update (full or partial) required in order to use the correct path.

### What is the cost-benefit between using `PUT` and `PATCH`?  

**PUT**
- **cost**: Requires sending the full object, even for minor changes, which increases data transfer.
- **benefit**: Ensures consistency when changing the entire resource.

**PATCH**
- **cost**: You need to specify which fields you want to update, which can increase the potential for errors.
- **benefit**: Applies changes to specific fields, reducing payload size.