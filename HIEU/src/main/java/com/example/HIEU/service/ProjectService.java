package com.example.HIEU.service;

import com.example.HIEU.entity.Image;
import com.example.HIEU.entity.Project;
import com.example.HIEU.entity.Student;
import com.example.HIEU.entity.User;
import com.example.HIEU.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void addProject(Project project, MultipartFile[] images, User user, List<Student> students) throws IOException {

            project.setUser(user);
            // Thêm học sinh vào dự án
            project.setStudents(students);

            // Lưu các ảnh
            List<Image> imageList = new ArrayList<>();
            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    Image image = new Image();
                    image.setName(file.getOriginalFilename());
                    image.setImageData(file.getBytes());
                    image.setProject(project);
                    imageList.add(image);
                }
            }
            project.setImages(imageList);
            // Lưu dự án và các ảnh vào cơ sở dữ liệu
            projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
