package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ProjectDao;
import com.devlink.devlink.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectDao.getProjectById(id);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @PostMapping
    public Long createProject(@RequestBody Project project) {
        return projectDao.createProject(project);
    }

    @PutMapping("/{id}")
    public boolean updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectDao.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProject(@PathVariable Long id) {
        return projectDao.deleteProject(id);
    }


    // non crud op:

    @GetMapping("/createdBy")
    public List<Project> getProjectsByCreator(@RequestParam("createdBy") Long createdBy) {
        return projectDao.getProjectsByCreator(createdBy);
    }

}
