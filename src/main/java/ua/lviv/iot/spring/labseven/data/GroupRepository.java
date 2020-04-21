package ua.lviv.iot.spring.labseven.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Group;
//import ua.lviv.iot.spring.labseven.rest.RestAplication.model.Student;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
