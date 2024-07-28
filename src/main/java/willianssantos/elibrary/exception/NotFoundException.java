package willianssantos.elibrary.exception;

public class NotFoundException extends Throwable {
    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found.");
    }
}
