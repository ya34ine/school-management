package com.school.management.service;

import com.school.management.entity.Teacher;
import com.school.management.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher teacherDetails) {

        return teacherRepository.findById(id)
                .map(teacher -> {

                    teacher.setFirstName(teacherDetails.getFirstName());
                    teacher.setLastName(teacherDetails.getLastName());
                    teacher.setEmail(teacherDetails.getEmail());
                    teacher.setSubject(teacherDetails.getSubject());

                    return teacherRepository.save(teacher);
                });
    }

    public boolean deleteTeacher(Long id) {

        if (!teacherRepository.existsById(id)) {
            return false;
        }

        teacherRepository.deleteById(id);
        return true;
    }
}