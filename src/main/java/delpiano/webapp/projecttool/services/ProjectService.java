package delpiano.webapp.projecttool.services;

import delpiano.webapp.projecttool.models.Project;
import delpiano.webapp.projecttool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public Project saveOrUpdateProject(Project project){
    return projectRepository.save(project);
  }


}
