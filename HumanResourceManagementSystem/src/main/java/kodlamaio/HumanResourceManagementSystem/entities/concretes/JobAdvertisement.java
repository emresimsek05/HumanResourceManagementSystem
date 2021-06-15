package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @NotBlank
    @NotNull
    @Column(name = "description" , length = 2000)
    @Type(type = "text")
    private String description;

    @NotBlank
    @NotNull
    @Column(name = "min_salary")
    private double minSalary;

    @NotBlank
    @NotNull
    @Column(name="max_salary")
    private Double maxSalary;

    @NotBlank
    @NotNull
    @Column(name="quota")
    private int quota;

    @NotBlank
    @NotNull
    @Column(name="application_deadline")
    private LocalDate applicationDeadline;

    @Column(name="created_date")
    private LocalDateTime createdDate;

    @Column(name="is_active")
    private boolean isActive;



}
