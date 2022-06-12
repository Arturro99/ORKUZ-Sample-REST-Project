package pl.edu.pw.orkuz.orkuz_project.endpoint;

import java.time.LocalDateTime;
import lombok.Value;

@Value
public class ErrorResponse {

    LocalDateTime dateTime;
    SingleError error;

    private ErrorResponse(SingleError singleError) {
        this.dateTime = LocalDateTime.now();
        this.error = singleError;
    }

    public static ErrorResponse error(String errorKey, String message) {
        return new ErrorResponse(new SingleError(errorKey, message));
    }
}
