package pl.edu.pw.orkuz.orkuz_project.exception;

import lombok.Getter;
import pl.edu.pw.orkuz.orkuz_project.exception.core.BaseException;
import pl.edu.pw.orkuz.orkuz_project.exception.core.ConflictException;
import pl.edu.pw.orkuz.orkuz_project.exception.core.NotFoundException;

@Getter
public class BookingException extends BaseException {

    private BookingException(BaseException exception) {
        super(exception, exception.getErrorKey());
    }

    public static BookingException notFoundException() {
        return new BookingException(NotFoundException.notFound("Booking not found", ErrorKey.BOOK_NOT_FOUND));
    }

    public static BookingException conflictException() {
        return new BookingException(ConflictException.conflict("Booking already exists", ErrorKey.BOOK_CONFLICT));
    }
}
