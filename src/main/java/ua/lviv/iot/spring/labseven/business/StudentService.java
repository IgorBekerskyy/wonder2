package ua.lviv.iot.spring.labseven.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.labseven.data.StudentRepository;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Students;

@Service
public class StudentService {
		
    @Autowired
    private StudentRepository studentRepository;

    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    public Students getStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Students createStudent(Students student) {
        return studentRepository.save(student);
    }

    public boolean deleteStudent(Integer id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Students updateStudent(Integer id, Students student) {
        if (studentRepository.existsById(id)) {
            Students previousStudent = studentRepository.findById(id).get();
            studentRepository.save(student);
            return previousStudent;
        } else {
            return null;
        }
    }

    public List<Students> getAllByFirstStudent(String firstStudent) {
        return studentRepository.findAllByFirstStudent(firstStudent);
    
	}
}
