package by.arsy.p8exception;

public class OptionalNullException extends NullPointerException{

    public OptionalNullException(Class<?> clazz) {
        super("Some optional field in " + clazz.getName() +" class is null");
    }
}
