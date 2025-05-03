# Milestone 2 Build Instructions #

- By Dylan Tran


- Assignment Specifications
    - Implementations for new methods are in XML.java
    - New unit tests written at the end of the following file:

    ``` JSON-java\src\test\java\org\json\junit\XMLTest.java ```

- Build and Test Commands
    - To build and run entire test suite:

    ``` mvn clean test ```

    - To run the tests that were added:

    ``` mvn test "-Dtest=org.json.junit.XMLTest#searchXMLGivenPathConverttoJSONTest" ```

    ``` mvn test "-Dtest=org.json.junit.XMLTest#replaceXMLGivenPathtoJSONTest" ```

    - To confirm that existing test suites still run:

    ``` mvn test ```
    
- Overall notes:
    - Modified the stock parse function and created two overloaded versions to handle search and replacement.
    - Maintained a path array that tracks the current path, navigating to the appropriate location to perform either the extraction function/replacement function
    - Implemented tags to help determine if we can speed up the processing part of the tree or exit early.
    