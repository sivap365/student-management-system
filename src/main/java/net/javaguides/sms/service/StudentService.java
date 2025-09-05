package net.javaguides.sms.service;

import org.springframework.data.domain.Page;

import net.javaguides.sms.entity.Student;

public interface StudentService {
    Page<Student> getAllStudents(int page, String keyword);
    void saveStudent(Student student);
    Student getStudentById(Long id);
    void updateStudent(Long id, Student student);
    void deleteStudentById(Long id);
}
