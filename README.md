# Java
In this bootcamp we will write a Java application which will expose TODO items. 

## Exercises
1. Create a Java application that reads all todo items from `src/main/resources/todo.csv` 
   Add an extra line that shows how many items are present in the todo list
   The output can be printed in the console.
   
    ```
    Items:
    - Buy groceries
    - Complete Timesheet
    - Finish User Story mht-6
    - Talk to Keshia about demo feedback
    - Write blogpost about TDD
    - Walk the dog
    - Prepare Java Bootcamp
    - Call dentist
    - Read changelog new spring boot version
    - Install new laptop
   
    Nr of items: 10
    ```
   
2. An item can have a priority: A, B, C, ... 
   Change the application so that it first shows the items with priority and in order
   The output can be printed in the console.
   
    ```
    Items:
    - Complete Timesheet
    - Prepare Java Bootcamp
    - Buy groceries
    - Finish User Story mht-6
    - Talk to Keshia about demo feedback
    - Write blogpost about TDD
    - Walk the dog
    - Call dentist
    - Read changelog new spring boot version
    - Install new laptop
   
    Nr of items: 10
    ```

3. An item can have a context, e.g. "optis". Change the application so that it only shows the items 
   that have the context "optis". Also, update the total at the last line.
   
    ```
    Items:
    - Complete Timesheet
    - Prepare Java Bootcamp
    - Talk to Keshia about demo feedback
    - Read changelog new spring boot version 

    Nr of items: 4
    ```

4. Create a REST endpoint using Spring Boot which will return all the items from the file. 
   The output will look like this: (the example only shows 3 items, but the complete file needs to be returned.)
    ```
    [
       {
           "description":"Complete Timesheet",
           "completed":false,
           "priority":"A",
           "completionDate":null,
           "creationDate":null,
           "projectTag":null,
           "contextTag":"optis"
       },
       {
           "description":"Prepare Java Bootcamp",
           "completed":false,
           "priority":"B",
           "completionDate":null,
           "creationDate":null,
           "projectTag":"bootcamp",
           "contextTag":"optis"
       },
       {
           "description":"Talk to Keshia about demo feedback",
           "completed":false,
           "priority":null,
           "completionDate":null,
           "creationDate":null,
           "projectTag":"manhattan",
           "contextTag":"optis"
       },
       ....
    ]
    ```

5. Change the REST endpoint so that a context can be added in the request. This context will be used to filter the items.
   The output will look like this:

    ```
    [
       {
           "description":"Complete Timesheet",
           "completed":false,
           "priority":"A",
           "completionDate":null,
           "creationDate":null,
           "projectTag":null,
           "contextTag":"optis"
       },
       {
           "description":"Prepare Java Bootcamp",
           "completed":false,
           "priority":"B",
           "completionDate":null,
           "creationDate":null,
           "projectTag":"bootcamp",
           "contextTag":"optis"
       },
       {
           "description":"Talk to Keshia about demo feedback",
           "completed":false,
           "priority":null,
           "completionDate":null,
           "creationDate":null,
           "projectTag":"manhattan",
           "contextTag":"optis"
       },
       {
           "description":"Read changelog new spring boot version",
           "completed":true,
           "priority":null,
           "completionDate":null,
           "creationDate":null,
           "projectTag":null,
           "contextTag":"optis"
       }
    ]
    ```

6. Also add the item count in the REST responses
   The output will look like this:

    ```
    {
        "count":4,
        "items":[
        {
            "description":"Complete Timesheet",
            "completed":false,
            "priority":"A",
            "completionDate":null,
            "creationDate":null,
            "projectTag":null,
            "contextTag":"optis"
        },
        {
            "description":"Prepare Java Bootcamp",
            "completed":false,
            "priority":"B",
            "completionDate":null,
            "creationDate":null,
            "projectTag":"bootcamp",
            "contextTag":"optis"
        },
        {
            "description":"Talk to Keshia about demo feedback",
            "completed":false,
            "priority":null,
            "completionDate":null,
            "creationDate":null,
            "projectTag":"manhattan",
            "contextTag":"optis"
        },
        {
            "description":"Read changelog new spring boot version",
            "completed":true,
            "priority":null,
            "completionDate":null,
            "creationDate":null,
            "projectTag":null,
            "contextTag":"optis"
        }
    ]
   }
    ```

7. Create a module that reads out the CSV file and puts the data in a database. This piece of logic needs to be executed everytime the application is starting.

8. Change all the REST endpoints so that they are using the database instead of the CSV file.

9. Create a web interface using React to show the todo list. This page also includes an option to filter on the context

10. (OPTIONAL) Secure the endpoints with Basic authentication