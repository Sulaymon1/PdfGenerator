package ru.itis.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    private String url;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Size(min = 1)
    private String name;

    @Size(min = 1)
    private String lastname;

    @Size(min = 1)
    private String courseName;

    @Size(min = 1)
    private String activityName;
}
