1. Did you use the same type of route to update patient information as to update an employee's department?

        No, I used a PUT request to update a patient's information and a PUT request with a path variable to update an employee's department.
2. Why did you choose the selected strategy?

        I chose the PUT request for updating patient information and employee's department because it allows the client to send the updated information in the request body. This strategy is more efficient and flexible compared to using PATCH requests, as it allows the client to send the entire object with the updated fields.
3. What are the advantages and disadvantages of the strategies you chose for creating these routes?

        Advantages:
        The PUT request allows the client to send the entire object with the updated fields, making it more efficient and flexible.
        The PUT request with a path variable allows the client to update a specific resource without having to specify the entire URL.

        
        Disadvantages:
        The PUT request does not support partial updates, which means that the client must send the entire object with the updated fields.
        The PUT request with a path variable does not support creating new resources, which means that the client must use a different strategy (e.g., POST) to create new resources.
4. What is the cost-benefit between using PUT and PATCH?
     
   
        The cost-benefit between using PUT and PATCH depends on the specific use case. If the client needs to send the entire object with the updated fields, then using a PUT request is more efficient and flexible. However, if the client needs to send only the updated fields, then using a PATCH request can be more appropriate. The choice between PUT and PATCH depends on the specific requirements of the application.