package ua.lviv.iot.spring.labseven.rest.RestAplication.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedNativeQuery(name = "Student.findBestStudent",
        query = "select * from student where id = 1")
public class Students {
    private String firstStudent;
    private String secondStudent;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties("students")
    private Group group;

    @ManyToMany(mappedBy = "students")
    @JsonIgnoreProperties("students")
    private Set<Subject> subjects;

    public Students() {
    }

    public Students(String firstStudent, String secondStudent) {
        this.firstStudent = firstStudent;
        this.secondStudent = secondStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstStudent() {
        return firstStudent;
    }

    public void setFirstStudent(String firstStudent) {
        this.firstStudent = firstStudent;
    }

    public String getSecondStudent() {
        return secondStudent;
    }

    public void setSecondStudent(String secondStudent) {
        this.secondStudent = secondStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

}
