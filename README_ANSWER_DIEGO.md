### 1. Did you use the same type of route to update patient information as to update an employee's department?
No, the routes for updating patient information and updating an employee's department utilize different HTTP methods. For updating the entire resource, we use the PUT method, whereas for updating specific attributes of a resource, we use PATCH.

### 2. Why did you choose the selected strategy?
The choice of strategy depends on the specific requirements of each operation. PUT is ideal for completely replacing a resource, whereas PATCH is more suitable when only certain attributes of the resource need to be updated.

### 3. What are the advantages and disadvantages of the strategies you chose for creating these routes?
PUT offers simplicity in implementation and understanding, making it suitable for smaller resources. However, it may be inefficient for large resources due to the requirement of replacing the entire resource. On the other hand, PATCH provides efficiency for large resources and allows for selective updates, but its implementation can be more complex.

### 4. What is the cost-benefit between using PUT and PATCH?
PUT is beneficial for its simplicity and suitability for smaller resources or when a complete replacement is necessary. Conversely, PATCH offers efficiency for large resources and provides more control over individual attributes, despite being more complex to implement. 