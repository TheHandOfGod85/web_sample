package delpiano.webapp.projecttool.controllers;

import delpiano.webapp.projecttool.models.Project;
import delpiano.webapp.projecttool.services.ProjectService;
import delpiano.webapp.projecttool.services.ValidationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/project")
public class ProjectController {
  @Autowired
  private ProjectService projectService;
  @Autowired
  private ValidationService validationService;

  @PostMapping("/")
  public ResponseEntity<?> createNewProject(@RequestBody @Valid  Project project, BindingResult result){
    ResponseEntity<?> errorMap = validationService.validationErrorService(result);
    if (errorMap!=null) return errorMap;
    // validate after a successful request
    Project project1 = projectService.saveOrUpdateProject(project);
    return new ResponseEntity<Project>(project, HttpStatus.CREATED);
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<?> getProjectById(@PathVariable String projectId){
    Project project = projectService.findProjectByIdentifier(projectId);
    return new ResponseEntity<Project>(project, HttpStatus.OK);
  }

}
