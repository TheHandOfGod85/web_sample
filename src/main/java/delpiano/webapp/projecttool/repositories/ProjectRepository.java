package delpiano.webapp.projecttool.repositories;

import delpiano.webapp.projecttool.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
  Project findByProjectIdentifier(String projectId);

}
