package ua.lviv.iot.springfirst.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.springfirst.rest.model.Student;

@RequestMapping("/students")
@RestController
public class StudentsController {
    private Map<Integer, Student> students = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @GetMapping
    public List<Student> getStudents() {
        return new LinkedList<Student>(students.values());
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(final @PathVariable("id") Integer studentId) {
        System.out.println(studentId);
        return new Student("pedro", "aldomovar");
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        students.put(student.getId(), student);
        student.setId(idCounter.incrementAndGet());
        return student;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer studentId) {
        HttpStatus status = students.remove(studentId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(final @PathVariable("id") Integer studentId,
            final @RequestBody Student student) {
        student.setId(studentId);
        HttpStatus status = students.put(studentId, student) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();

    }
}
