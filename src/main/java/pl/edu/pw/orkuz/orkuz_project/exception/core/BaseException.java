package pl.edu.pw.orkuz.orkuz_project.exception.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private final String errorKey;

    private BaseException(BaseException exception) {
        this(exception, exception.getErrorKey());
    }

    protected BaseException(String message, String errorKey) {
        super(message);
        this.errorKey = errorKey;
    }

    protected BaseException(Throwable cause, String errorKey) {
        super(cause);
        this.errorKey = errorKey;
    }
}
