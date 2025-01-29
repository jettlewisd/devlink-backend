package com.devlink.devlink.controller;

import com.devlink.devlink.dao.SkillDao;
import com.devlink.devlink.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
@CrossOrigin
public class SkillController {

    private final SkillDao skillDao;

    @Autowired
    public SkillController(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillDao.getSkillById(id);
    }

    @GetMapping("/users/{user_id}")
    public List<Skill> getSkillsByUserId(@PathVariable Long user_id) {
        return skillDao.getSkillsByUserId(user_id);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillDao.getAllSkills();
    }

    @PostMapping
    public Long createSkill(@RequestBody Skill skill) {
        return skillDao.createSkill(skill);
    }

    @PutMapping("/{id}")
    public boolean updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return skillDao.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSkill(@PathVariable Long id) {
        return skillDao.deleteSkill(id);
    }

    @GetMapping("/filter/proficiency/{proficiency_level}")
    public List<Skill> findSkillsByProficiency(@PathVariable String proficiency_level) {
        return skillDao.findSkillsByProficiency(proficiency_level);
    }

    @GetMapping("/users/{user_id}/skills/{skill_name}")
    public boolean userHasSkill(@PathVariable Long user_id, @PathVariable String skill_name) {
        return skillDao.userHasSkill(user_id, skill_name);
    }
}
