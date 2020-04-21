package ua.lviv.iot.spring.labseven.rest.RestAplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.spring.labseven.business.StudentService;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Students;;

@RequestMapping("/students")
@RestController
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public final List<Students> getStudents(final @RequestParam(value = "firstStudent", required = false) String firstStudent) {
        if (firstStudent == null) {
            return studentService.getStudents();
        }
        return studentService.getAllByFirstStudent(firstStudent);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Students> getSportBuild(final @PathVariable("id") Integer id) {
        Students studentNow;
        return (studentNow = studentService.getStudent(id)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(studentNow, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public final Students createStudent(final @RequestBody Students student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public final ResponseEntity<Students> deleteStudent(final @PathVariable("id") Integer id) {
        HttpStatus status = studentService.deleteStudent(id) ? HttpStatus.OK :
                HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @PutMapping(path = "/{id}")
    public final ResponseEntity<Students> updateStudent(final @PathVariable("id") Integer id,
                                                       final @RequestBody Students sportBuild) {
        sportBuild.setId(id);
        Students previousStudent;
        return (previousStudent = studentService.updateStudent(id, sportBuild)) == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(previousStudent, HttpStatus.OK);
    }
}
