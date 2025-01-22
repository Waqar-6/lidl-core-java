package shared.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s does not exists with the %s : '%s'", resource, field, value));
    }
}
