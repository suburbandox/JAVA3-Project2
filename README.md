az webapp deploy --resource-group java-kline --name ethan-java --src-path ./target/java3-project2-1.0-SNAPSHOT
.war --type war

# Final Project

This is the final project for my CIS-181 Java III course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Chapters 1 and 2
In the first chapter, the text author reviewed the history of Java Platform, Enterprise Edition. They went over the earl versions and described how the Enterprise Edition branched off from the Standard Edition. It is important to have a good understanding of JAVA SE to become a good JAVA EE coder.  The chapter introduced Servlets (a Java class that is responsible for accepting and responding to HTTP requests), Listeners (which notify code of events), and JSPs (which help to create graphical user interfaces for web applications. It went over the directory structure and other aspects of JAVA architecture.

Chapter 2 introduces JAVA EE application servers and Web Containers and describes their use. It went over how to install Tomcat on my home computer and discussed how to debug Tomcat from IntelliJ IDEA and Eclipse. 

## Chapters 3 and 4
Chapter 3 introduced the servlet class, which is a small Java program that runs inside a web server. These programs code interactions between web clients and servers as a part of HTTP. Servlets use Doget and Dopost methods, which specifically get and post information on forms. One important aspect of Java servlets is their use in uploading files.

Chapter 4 focus on JSPs, Java Server Pages. Inside a JSP, you can use specific ways of using Java code: directives, declarations, scriptlets, and expressions.  Directives direct the JSP interpreter to perform an action. Declarations declare something in the scope of the JSP Servlet class. Scriptlets generate Java code. Expressions return something that can be written to the client output. 
Finally, we hooked up our code to Azure.