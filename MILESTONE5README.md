# Milestone 5 README #

- By Dylan Tran


- Assignment Specifications
    - Added an asynchronous overloaded toJSONObject method to **XML.java**, with the following signature:
    
    ```
    public static Future<Boolean> toJSONObject(Reader reader, Consumer<JSONObject> onSuccess, Consumer<Exception> onError) throws JSONException

    ```

    - Method takes advantage of existing parse functionality.
    - This method returns a **Future** object which indicates a success or a failure (i.e. if the success callback occurred, or the error callback occurred)

- Build and Test Commands
    - To build and run entire test suite:

    ``` mvn clean test ```

    - To run the test that was added to **XMLTest.java**:

    ``` mvn test "-Dtest=org.json.junit.XMLTest#asyncToJSONObjectTest" ```

    - To confirm that existing test suites still run:

    ``` mvn test ```
    

    