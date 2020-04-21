package ua.lviv.iot.spring.labseven.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.labseven.data.SubjectRepository;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Subject;
import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Students;


import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }


    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}