package ua.lviv.iot.spring.labseven.rest.RestAplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.spring.labseven.business.SubjectService;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Subject;

@RequestMapping("/subjects")
    @RestController
    public class SubjectController {

        @Autowired
        private SubjectService subjectService;

        @GetMapping
        public List<Subject> getSubjects() {
            return subjectService.getSubjects();
        }

        @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
        public final Subject createSubject(final @RequestBody Subject subject) {
            return subjectService.createSubject(subject);
        }
    }


