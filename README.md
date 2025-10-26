# Description
Automation framework built using the tools Selenium for browser, RestAssured for API, Cucumber for BDD integration and Maven for dependencies management, the code is built with Java and Gherkin.

# Requirements
- Maven
- Java 21
- Edge Browser

# Running Tests
## Initial Run
To build the maven project open the project in either the IDE or the terminal at the repository and running `mvn clean install`. The command will download any necessary dependencies

## Running Test Cases
To specify the test case to run update the tags property in the TestRunner file, the current tags in the project are `@mvsd` and `@author`

To run test cases use `mvn clean test` or `mvn test` specified in the tag of the TestRunner. Using clean will delete the target folder, deleting previous reports.

JUnit can be used to run the test case from the TestRunner, previous reports will not be deleted when run through this method


# Reporting
Reports will be created in the target folder, the folder will be generated after the initial run. 



