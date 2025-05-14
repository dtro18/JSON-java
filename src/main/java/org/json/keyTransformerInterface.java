@FunctionalInterface
public interface KeyTransformerInterface {
    String apply(String inputString);
}

class StringModifier implements KeyTransformerInterface {
    public static apply(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
       
    }
}