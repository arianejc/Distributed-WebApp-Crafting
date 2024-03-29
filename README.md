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

Create an index.jsp page that asks the user to enter a string of text data, and to make a choice of two hash functions using radio buttons. The hash function choices should be MD5 and SHA-256, with MD5 being the default. When the submit button is pressed a request is sent to a servlet. The servlet must be named ComputeHashes.java. The servlet will compute the requested cryptographic hash value (MD5 or SHA-256) from the text transmitted by the browser. You will need to employ the Java crypto API to compute the hash of the text. The original text will be echoed back to the browser along with the name of the hash, and the hash value. The hash values sent back to the browser should be displayed in two forms: as hexadecimal text and as base 64 notation. We will discuss the use of such hash values later in the course. To compute the MD5 and SHA-256 hashes, use these standard java packages:

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
To print the Base64 encoding, use the following method:

jakarta.xml.bind.DatatypeConverter.printBase64Binary()
To print the hexadecimal encoding, use the following method:

jakarta.xml.bind.DatatypeConverter.printHexBinary()
To include the DatatypeConverter class into your project, use:

import jakarta.xml.bind.DatatypeConverter;
and add these lines to your pom.xml file, then refresh Maven:

<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>4.0.1</version>
</dependency>

Because Task 1 is fairly simple, you do not have to use MVC for it. Do the simplest thing possible (however, feel free to use MVC if you'd like).

Be sure to create screen shots of your working application and submit them as described in the Submission section at the end of this document.

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


  
