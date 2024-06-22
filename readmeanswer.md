
- Did you use the same type of route to update patient information as to update an employee's department?
- For patient I used PostMapping and for the employee's department Patch mapping.
- Why did you choose the selected strategy?
- for the employee's department I used the PatchMapping because I only updated one information, and
- for patient I used PutMapping because I update all the information.
- What are the advantages and disadvantages of the strategies you chose for creating these routes?
- Advantages:
  PUT: Ensures full resource replacement, clear and explicit updates.
  PATCH: Allows for partial updates, reducing network overhead and complexity.
  Disadvantages:

  PUT: Heavier on data transfer, may lead to unnecessary updates.
  PATCH: Requires careful implementation to handle partial updates correctly.
-
-
- What is the cost-benefit between using `PUT` and `PATCH`?
- Put has higher payloads compared to Patch because it is used to update a resource entirely, Put can use more bandwidth.
- Put is idempotent.