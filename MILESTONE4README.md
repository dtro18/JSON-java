# Milestone 4 README #

- By Dylan Tran


- Assignment Specifications
    - Built out a JSONObject serializer that chunks JSONObjects into nodes, which
      are then sent through a stream.
    - Stream supports every element, but loses nesting information i.e. we send each key as its own node, but provide no information about which nodes are children of other nodes.
    - Core Assumption:  
        - Nodes are defined as such:
        ``` 
        public static class JSONStreamNode {
            public String key;
            public String strVal;
            public Object nestedJson;
        } 
        ```
        Where key/strVal are key/value pairs, and nestedJson is a nested JSONObject, if one exists.
    - Nodes are then sent recursively using a spliterator combined with a stack for a bfs approach.
    - When a nested node is reached, it is processed, and its children are added to a queue.
    - Children are popped from the queue in the tryAdvance function to be processed.
    - Code was added to JSONObject.java (at the bottom), under the following signatures:
        ```
        public static class JSONStreamNode
        public static class JSONNodeSpliterator implements Spliterator<JSONStreamNode>
        public Stream<JSONStreamNode> toStream();
        ```
    
    - Test cases added to JSONObjectTest.java.

- Build and Test Commands
    - To build and run entire test suite:

    ``` mvn clean test ```

    - To run the test that was added:

    ``` mvn test "-Dtest=org.json.junit.JSONObjectTest#JSONObjToStreamTest" ```

    - To confirm that existing test suites still run:

    ``` mvn test ```
    

    