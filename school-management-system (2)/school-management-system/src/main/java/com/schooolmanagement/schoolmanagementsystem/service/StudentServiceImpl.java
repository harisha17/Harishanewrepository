package com.schooolmanagement.schoolmanagementsystem.service;



import com.schooolmanagement.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student studentDetails) {
        Student student = studentRepository.findById(studentDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",studentDetails.getId()));

        student.setEmail(studentDetails.getEmail());

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        String delete = "successfully deleted";
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",id));

        studentRepository.deleteById(id);
    }


}
