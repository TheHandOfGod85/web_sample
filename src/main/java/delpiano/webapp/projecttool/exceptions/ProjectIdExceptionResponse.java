package delpiano.webapp.projecttool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
// an object to handle the exception of the JSon response
@AllArgsConstructor
@Getter
@Setter
public class ProjectIdExceptionResponse {

  private String projectIdentifier;

}
