package pl.java.scalatech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "brak autoryzacji")
public class My401Exception extends RuntimeException {

}
