package delpiano.webapp.projecttool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
// exception class that return a message at runtime
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

  public ProjectIdException(String message) {
    super(message);
  }
}
