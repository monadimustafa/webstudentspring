package com.nada.spring.Service;

import com.nada.spring.Model.Student;
import com.nada.spring.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getStudentList(){
        Iterable<Student> students= studentRepository.findAll();
        return  (List<Student>) students;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        else
            throw new IllegalArgumentException("Student non existant");
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
