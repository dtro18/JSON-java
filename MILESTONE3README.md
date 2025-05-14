# Milestone 3 README #

- By Dylan Tran


- Assignment Specifications
    - Implementation for new datatype, KeyTransformerInterface, is in a separate file: KeyTransformerInterface.java.
        - It made sense to separate this interface from the XML.java file.

    - Implementations for three new associated methods are in XML.java:
        - ``` private static String applyTransformation(String inputString, KeyTransformerInterface keyTransformer) ```
            - Validates the user-provided function
        - ``` public static JSONObject toJSONObject(Reader reader, XMLParserConfiguration config, KeyTransformerInterface keyTransformer) ```
            - Calls the appropriate parsing function
        - ``` private static boolean parse(XMLTokener x, JSONObject context, String name, XMLParserConfiguration config, int currentNestingDepth, KeyTransformerInterface keyTransformer) ```
            - New parsing function that applies the transformation to the tagnames
            
    - New unit test written at the end of the following file:

    ``` JSON-java\src\test\java\org\json\junit\XMLTest.java ```

- Build and Test Commands
    - To build and run entire test suite:

    ``` mvn clean test ```

    - To run the test that was added:

    ``` mvn test "-Dtest=org.json.junit.XMLTest#keyTransformerTest" ```

    - To confirm that existing test suites still run:

    ``` mvn test ```
    
- Overall notes:
    - User-provided transformation is an implementation of the KeyTransformerInterface class. The user should create a class that implements this interface.
    - This transformation had some constraints put on it per the problem specification
        - The transformation should throw an error if it provides a null/empty string, or if it contains spaces.
    - Performance implication - applying the transformation as we are parsing means we only make one pass (n) through the given JSONObject, rather than two (2n).

    