package camt.cbsd.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Admin on 16/4/2560.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull long id;
    @NonNull String courseId;
    @NonNull String courseName;
}
