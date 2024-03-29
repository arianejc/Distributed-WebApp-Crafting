# Distributed-WebApp-Crafting
In this project, I craft dynamic web apps with Servlets &amp; JSPs, explore distributed systems. I also utilize web scraping, API integration, JSON handling, &amp; MVC for robust development.

This project serves as a comprehensive exploration of distributed systems and advanced web development techniques, leveraging IntelliJ and TomEE. Key features of the project include:

* Crafting dynamic web applications using Servlets and Java Server Pages (JSPs), delving into the intricacies of distributed systems architecture.
* Harnessing the power of web scraping techniques to gather and process data from diverse sources.
* Implementing API processing methodologies to integrate external services seamlessly into web applications.
* Working extensively with JSON records for efficient data exchange and manipulation.
* Embracing the Model-View-Controller (MVC) pattern for structured and maintainable web application development.
* Reflect on the functional and non-functional characteristics (e.g. security, scalability, failure handling, interoperability) of the solutions.

**Task 1**

1. Index.jsp Page:
   - Create an index.jsp page with input fields for text data and radio buttons to choose between MD5 and SHA-256 hash functions. MD5 should be the default choice.

2. ComputeHashes Servlet:
   - Develop a servlet named ComputeHashes.java to handle the form submission.
   - Use the Java crypto API to compute the selected cryptographic hash value (MD5 or SHA-256) from the text data transmitted by the browser.

3. Hash Value Display:
   - Display the original text, the name of the hash function, and the computed hash value.
   - Show the hash values in both hexadecimal and base 64 notation.

4. DatatypeConverter Usage:
   - Utilize the DatatypeConverter class to print the base 64 and hexadecimal encodings.

5. Dependency Addition:
   - Include the DatatypeConverter class in the project and add the required dependency in the pom.xml file.

6. Submission:
   - Create screenshots of the working application as per the submission guidelines.

Ensure that the index.jsp page prompts the user for input and hash function selection, the servlet computes the hash value accurately, and the output is displayed correctly on the browser. Screenshots of the application's functionality should be provided as part of the submission.

**Task 2**

This project involves creating a web application named "ClickerApp" using IntelliJ. The app allows users to submit answers to class questions via desktop and mobile interfaces. Users receive feedback upon submission and can make additional submissions. The app features a separate endpoint ("/getResults") to display submitted responses along with the number of times each answer was submitted. Requirements include using MVC architecture, implementing only one HttpServlet, and ensuring mobile compatibility. Screen shots demonstrating the desktop and mobile interfaces for answer submission and results display are required.

**Task 3**

For this task, you're required to develop a web application centered around Major League Baseball (MLB) information. 

1. User Input Page:
   - Provide a drop-down menu for users to select a state.
   - Offer choices for data related to MLB teams.

2. MLB Team Details:
   - Utilize an API to display basic team details from simple JSON data.
   - Use the Gson library to handle JSON records.

3. Additional Team Information:
   - Include at least two other facts about the team obtained through web scraping or APIs.
   - Incorporate two official team items (e.g., team flag, logo) with corresponding images.

4. Dynamic Content:
   - Ensure the output is dynamic and can handle different user inputs.
   - The output should be repeatable for the same input data.

5. Web Interaction Features:
   - Design a web interface with a text field, button, drop-down menu, and radio buttons for user interaction.
   - Utilize one page for user input and at least two pages for output.

6. MVC Pattern and Separation of Concerns:
   - Implement the Model-View-Controller (MVC) pattern for well-structured code.
   - Maintain good separation of concerns for clear code organization.

7. Error Handling:
   - Handle error conditions in a reasonable manner to ensure a smooth user experience.

8. Documentation:
   - Document the code comprehensively, including usage instructions and the app's design/structure.
   - Clearly cite all websites and resources used for MLB data, web scraping, and APIs.



**Summary:**

Task 1:
Screen shots of input, MD5 and SHA-256 output, both in hex and base 64
Code snippets of computation of each hash

Task 2:
Screen shots of input page(s) and output page(s).
Code snippets for producing clicker output.

Task 3:
Screen shots of two uses of the input page (two different sets of input data) and the corresponding output pages.
Code snippets from the Java code that screen scrapes, queries the API, and produces output.


  
