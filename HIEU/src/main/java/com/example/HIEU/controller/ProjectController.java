package com.example.HIEU.controller;

import com.example.HIEU.entity.Project;
import com.example.HIEU.entity.Student;
import com.example.HIEU.entity.User;
import com.example.HIEU.repository.ProjectRepository;
import com.example.HIEU.service.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping()
    public String showListProject(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projectList";
    }

    @GetMapping("/{id}")
    public String showDetailProject(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id);
        model.addAttribute("project", project);
        return "detailProject";
    }

    @GetMapping("/add")
    public String showPageAddProject(HttpSession session, Model model) {
        String sessionName = (String) session.getAttribute("userName");
        model.addAttribute("sessionName", sessionName);
        model.addAttribute("project", new Project());
        return "addProjectPage";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute Project project,
                             @RequestParam("images") MultipartFile[] images,
                             @RequestParam("user") User user,
                             @RequestParam("students") List<Student> students) {
        projectService.addProject( project,images,user,students);
        return "redirect:/projects";
    }
}
