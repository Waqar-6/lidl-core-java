package shared.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String resource, String field, String value) {
        super(String.format("%s already exists with the %s : '%s'", resource, field, value));
    }
}
