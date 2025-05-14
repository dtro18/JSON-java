package org.json;
    /**
     * A functional interface representing a client-provided key transformation function.
     * Users implement this interface and override the apply function.
     * <p>Used to transform keys during XML-to-JSON conversion.</p>
     * Example usage: {@code
     * KeyTransformerInterface transformer = originalKey -> originalKey.toUppercase(); // example override of apply function }
     * @param inputString A tagname in string format.
     * @return A modified tagname in string format.
     * @throws IllegalArgumentException Thrown if the output string is invalid.
     */

@FunctionalInterface
public interface KeyTransformerInterface {
    String apply(String inputString) throws IllegalArgumentException;
}

