## Questions

### Did you use the same type of route to update patient information as to update an employee's department?

No, for updating patient information, I used a `PUT` route, while for updating an employee's department, I used a `PATCH` route.

### Why did you choose the selected strategy?

I chose `PUT` for updating patient information because typically, it implies a full update of the resource. If any field is missing, it could optionally be reset to null or some default. This is because patient information update usually involves multiple fields.
For updating a doctor's department, I used `PATCH` since it represents a partial update, which is more efficient when you intend to change only one or a few fields.

### What are the Merits and Demerits of the strategies you chose for creating these routes?

**Merits:**

- **PUT for patients:** Makes it clear that the entire patient record is being updated, reducing ambiguity.
- **PATCH for departments:** More efficient for small updates and less data transfer.

**Demerits:**

- **PUT for patients:** Requires the client to send the full patient object, even if only a couple of fields are changed.
- **PATCH for departments:** Slightly more complex in terms of validation because it only updates parts of the resource.

### What is the cost-benefit between using PUT and PATCH?

- **PUT:
