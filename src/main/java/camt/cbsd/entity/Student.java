package camt.cbsd.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.Nullable;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Created by Dto on 3/11/2017.
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull long id;
    @NonNull  String studentId;
    @NonNull String name;
    @NonNull String surname;
    @NonNull double gpa;
    @NonNull String image;
    @NonNull boolean feature;
    @NonNull int penAmount;
    @NonNull String description;


    @ManyToMany
    List<Course> enrolledCourse;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (Double.compare(student.gpa, gpa) != 0) return false;
        if (feature != student.feature) return false;
        if (penAmount != student.penAmount) return false;
        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (image != null ? !image.equals(student.image) : student.image != null) return false;
        return description != null ? description.equals(student.description) : student.description == null;
    }

    public  List<Course> addCourse(Course course){
        enrolledCourse = Optional.ofNullable(enrolledCourse).orElse(new ArrayList<>());
        enrolledCourse.add(course);
        return enrolledCourse;
    }


}
