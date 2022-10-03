package delpiano.webapp.projecttool.controllers;

import delpiano.webapp.projecttool.models.Project;
import delpiano.webapp.projecttool.services.ProjectService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/project")
public class ProjectController {
  @Autowired
  private ProjectService projectService;

  @PostMapping("/")
  public ResponseEntity<?> createNewProject(@RequestBody @Valid  Project project, BindingResult result){
    // check validation and give a response for bad request with a field and the error message
    if (result.hasErrors()){
      Map<String, String> errorMap = new HashMap<>();
      for (FieldError error: result.getFieldErrors()){
        errorMap.put(error.getField(), error.getDefaultMessage());
      }
      return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
    }
    // validate after a successful request
    Project project1 = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
  }

}
