# Testing-projects

## [Testing and Defect Tracking](Testing%20and%20Defect%20Tracking.md)

This project involves an exploration of different testing techniques, applied to an ATM simulation developed by [Gordon College](https://www.math-cs.gordon.edu/courses/cs211/ATMExample/Links.html). It involves familiarization with a System Under Test (SUT) and defect tracking system, exploratory and scripted testing, and regression testing. The objectives include gaining practical experience in testing, understanding different testing types, and becoming familiar with defect tracking systems. The project also includes pair testing and group work components.

## [Black Box Testing](./Black%20Box%20Testing.md)

[![Language](https://img.shields.io/badge/language-Java-blue.svg)](https://www.java.com/)
[![JUnit](https://img.shields.io/badge/JUnit-4.11-green.svg)](https://junit.org/junit4/)

In this project, we conducted black-box testing on the Range and DataUtilities classes in the [JFreeChart](https://www.jfree.org/jfreechart/) framework, used for charting in Java. Despite lacking access to the source code, we developed test plans and cases for 10 methods across these classes. Our process involved setting up Eclipse environments, dividing methods among team members, and creating, evaluating, and implementing test plans collectively. We tested various input partitions and boundary values, overcoming challenges like unclear documentation and mocking complexities. Our tests uncovered issues, such as the getUpperBound method returning the lower bound instead, demonstrating the importance of thorough testing even without access to source code.

## [White Box Testing](./White%20Box%20Testing.md)

[![Language](https://img.shields.io/badge/language-Java-blue.svg)](https://www.java.com/)
[![JUnit](https://img.shields.io/badge/JUnit-4.11-green.svg)](https://junit.org/junit4/)
![EclEmma Code Coverage](https://img.shields.io/badge/branch%20coverage-87.5%25-brightgreen)

This report details our white-box testing efforts on the Range and DataUtilities classes in the JFreeChart framework. Building on our previous black-box testing project, we used Eclipse with JUnit and EclEmma for coverage analysis. Our objectives included designing effective test cases, improving code coverage, and assessing test quality based on coverage metrics.

We refactored our test suite for better organization and readability, and analyzed coverage for methods like `calculateColumnTotal` and contains. We also developed new unit tests to meet minimum coverage requirements.

Key findings include challenges in determining optimal test case numbers and the importance of not relying solely on high coverage metrics. White box testing provides a structured approach to identifying defects but doesn't guarantee fault-free software.

## [Mutation Testing and GUI Testing](./Mutation%20Testing%20and%20GUI%20Testing.md)

[![Language](https://img.shields.io/badge/language-Java-blue.svg)](https://www.java.com/)
[![JUnit](https://img.shields.io/badge/JUnit-4.11-green.svg)](https://junit.org/junit4/)
[![Pitest Tested](https://img.shields.io/badge/Pitest-Tested-brightgreen)](https://pitest.org/)

[![Selenium Tested](https://img.shields.io/badge/Selenium-Tested-brightgreen)](https://selenium.dev/)

This project includes two parts: Mutation Testing and GUI Testing.

Through part one, we inject mutation faults in a Java code-base using a mutation testing tool and how to interpret the reported mutation scores and use that knowledge to design new test cases to improve the overall quality of the test suite.

Part two, focuses on most common way of GUI test automation, record and replay. We use Selenium, a very well-known tool for web interface testing.

## [Reliability Assessment](./Reliability%20Assessment.md)

This project aims to expand our understanding of software reliability assessment methods and tools, and their ability to apply these methods in practice. We analyzed the provided failure data, and documented the results for both parts. The evaluation criteria include the accuracy of the analysis, the justification of the chosen parameters, and a comparison of the results obtained from both techniques.

In the first part, we use a reliability assessment tool (C-SFRAT), analyze integration test data, and create plots of failure rate and reliability of the System Under Test (SUT). This allowed us to assesses the reliability of a system and familiarize ourselves with the features of the selected tool.

In the second part, students will use RDC to check whether the target failure rate or Mean Time To Failure (MTTF) of the SUT is met. RDC is based on collecting failure data at specific time points and is useful when failure data is limited.
