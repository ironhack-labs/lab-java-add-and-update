README Short Answer Questions

Did you use the same type of route to update patient information as to update an employee's department?
- No, I used `PUT` for patient information because it involves multiple fields, and `PATCH` for employee's department since it changes only one field.

Why did you choose the selected strategy?
- `PUT` ensures full resource update, while `PATCH` allows partial updates.

Advantages and Disadvantages of Strategy:
- Advantages: Ensures clarity in API design.
- Disadvantages: Requires separate implementations for similar logic.

Cost-Benefit between PUT and PATCH:
- `PUT` is simpler for replacing entire objects, while `PATCH` is efficient for small updates.
