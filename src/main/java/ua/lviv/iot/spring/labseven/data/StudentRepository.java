package ua.lviv.iot.spring.labseven.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Students;
@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {

    List<Students> findAllByFirstStudent(String firstStudent);

    List<Students> findAllByFirstStudentAndSecondStudent(String firstStudent, String secondStudent);

   // Students findBestStudent();

}
