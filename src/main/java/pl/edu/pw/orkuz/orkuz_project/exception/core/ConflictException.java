package pl.edu.pw.orkuz.orkuz_project.exception.core;

public class ConflictException extends BaseException {

    private ConflictException(String message, String errorKey) {
        super(message, errorKey);
    }

    public static ConflictException conflict(String message, String errorKey) {
        return new ConflictException(message, errorKey);
    }
}
