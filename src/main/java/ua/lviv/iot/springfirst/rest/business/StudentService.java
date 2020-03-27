package ua.lviv.iot.springfirst.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.springfirst.rest.dataaccess.StudentRepository;
import ua.lviv.iot.springfirst.rest.model.Student;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }
}