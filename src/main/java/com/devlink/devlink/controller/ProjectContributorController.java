package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ProjectContributorDao;
import com.devlink.devlink.model.ProjectContributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_contributors")
@CrossOrigin
public class ProjectContributorController {

    private final ProjectContributorDao projectContributorDao;

    @Autowired
    public ProjectContributorController(ProjectContributorDao projectContributorDao) {
        this.projectContributorDao = projectContributorDao;
    }


    @GetMapping("/{user_id}/{project_id}")
    public ProjectContributor getContributorById(@PathVariable Long user_id, @PathVariable Long project_id) {
        return projectContributorDao.getContributorById(user_id, project_id);
    }

    @PostMapping
    public boolean addContributor(@RequestBody ProjectContributor project_contributor) {
        return projectContributorDao.addContributor(project_contributor);
    }

    @PutMapping
    public boolean updateContributor(@RequestBody ProjectContributor project_contributor) {
        return projectContributorDao.updateContributor(project_contributor);
    }

    @DeleteMapping("/{user_id}/{project_id}")
    public boolean removeContributor(@PathVariable Long user_id, @PathVariable Long project_id) {
        return projectContributorDao.removeContributor(user_id, project_id);
    }

    @GetMapping("/projects/{project_id}/contributors")
    public List<ProjectContributor> getContributorsByProjectId(@PathVariable Long project_id) {
        return projectContributorDao.getContributorsByProjectId(project_id);
    }

    @GetMapping("/{user_id}/{project_id}/status")
   public boolean isUserContributing(@PathVariable Long user_id, @PathVariable Long project_id) {
        return projectContributorDao.isUserContributing(user_id, project_id);
   }
}
