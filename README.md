# Sauce demo project

# Description
This is a project created to perform automation testing in the sauce demo page. It is created following the POM design pattern, created with Java, Selenium, Maven and TestNG. It is created to test https://www.saucedemo.com/. It tests the users logins, adding products to
the shopping cart, etc.

# Table of Contents
1. [Installation]
2. [Configuration]
3. [Testing]

## Installation
1. Open your preferred IDE. This project was developed on Eclipse for Java developers, with the free license.
2. Install the latest version of maven, in order to manage the libraries and the selenium integration. The maven compiler is the key in the process of integration and compilation.
3. Make sure Java Development Kit 22 is installed in your pc.
4. Download the repository

## Configuration
Make sure the pom.xm file has the correct dependencies and configurations.
JDK 22 needs to be set as environment variable.

## Testing
The test classes are the ones intended to be used. They can be recognized as their name end with "test", e.g. "HomePageTests". 
In order to be able to run tests, make sure the pom.xml file contains the TestNG dependency.
