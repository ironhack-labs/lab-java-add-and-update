
Did you use the same type of route to update patient information as to update an employee's department?
  No, when we want to update a entire resources we use PUT and when we update only some variables of resource we use PATCH.

Why did you choose the selected strategy?
  Because it's is more specific for each case.

What are the advantages and disadvantages of the strategies you chose for creating these routes?
  The most advantage of PUT it is that is more easy to implement and the principle disadvantage is that is inefficient for large resources.
  Patch is more efficient for large resources or when you need to update an specific variable but it can be more difficult to implement.

What is the cost-benefit between using PUT and PATCH?
  Put is more simple to implement and understand and it is useful for smaller resources or when it is totally necessary the full replacement.
  Patch is more efficient for large resources, it is more complex but it also allow to have more control on each variable.
