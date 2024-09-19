Write a short answer in README.md. In your README.md, write a short answer to the following questions:

Did you use the same type of route to update patient information as to update an employee's department?
    I used a different route. To update the patient's information, I used a PUT to change any attribute. However, 
    to modify a specific attribute, in this case the department, I used PATCH.

Why did you choose the selected strategy?
    Because if I only need to change one attribute, I only need to pass that parameter. It is not necessary to pass
    the entire object, which is why I preferred PATCH.

What are the advantages and disadvantages of the strategies you chose for creating these routes?
    The advantage is that I only need to pass one parameterº1 when I want to change the department. The disadvantage 
    is that I cannot change anything else. However, I think it's better because it's easier and more manageable to pass a parameter rather than the entire object every time I want to modify something. If I'm unsure of what I will modify, I do use PUT because it allows me to pass the whole object and then change the necessary attribute from there.

What is the cost-benefit between using PUT and PATCH?
    PUT replaces the entire resource, which means the state of the resource is exactly what you send, avoiding 
    inconsistent data.
    If I need to update all fields, PUT is more straightforward because you send the entire updated object.
    But if you don’t include all the data of the resource, you might accidentally overwrite unintended information.
    PATCH only sends the parts of the resource that need to be updated, which reduces the payload size and bandwidth 
    usage.
    It is safer if you only want to modify some fields of the resource without worrying about overwriting other data.