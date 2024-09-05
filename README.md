6. **Write a short answer in README.md**. In your `README.md`, write a short answer to the following questions:

   - Did you use the same type of route to update patient information as to update an employee's department?

      Yes, I use the same type of controller and the same type of route "/{id}", but the URL is different because before that it has to be the route "/employee/" or "/patient/"

   - Why did you choose the selected strategy?

      I selected the PatchVariable because the variable is not selected or changed by the user.

   - What are the advantages and disadvantages of the strategies you chose for creating these routes?

      This way you can map the variable ID in the URL, without having to write the ?.

   - What is the cost-benefit between using `PUT` and `PATCH`?

      PUT is easier to program, and it takes less logic to work, but PATCH is a lot more efficient.
