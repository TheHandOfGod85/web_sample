package delpiano.webapp.projecttool.services;

import delpiano.webapp.projecttool.exceptions.ProjectIdException;
import delpiano.webapp.projecttool.models.Project;
import delpiano.webapp.projecttool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;
   // save or update a project
  public Project saveOrUpdateProject(Project project){
    // checks if the project already exists in the database
    try {
      //setting the identifier to uppercase before saving it
      project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
      return projectRepository.save(project);
    }catch (Exception e){
      // throws the custom exception if the project already exists
      throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
    }
  }
  // find a project by identifier
  public Project findProjectByIdentifier(String projectId){
    Project project =  projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project == null){
      throw new ProjectIdException("Project ID  '"+projectId+"' does not exists");
    }
    return project;

  }



}
