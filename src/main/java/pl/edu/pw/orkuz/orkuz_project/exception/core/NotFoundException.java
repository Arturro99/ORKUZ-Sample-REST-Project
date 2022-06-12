package pl.edu.pw.orkuz.orkuz_project.exception.core;

public class NotFoundException extends BaseException {

    private NotFoundException(String message, String errorKey) {
        super(message, errorKey);
    }

    public static NotFoundException notFound(String message, String errorKey) {
        return new NotFoundException(message, errorKey);
    }
}
