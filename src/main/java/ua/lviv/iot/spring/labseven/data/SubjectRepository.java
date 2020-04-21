package ua.lviv.iot.spring.labseven.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
