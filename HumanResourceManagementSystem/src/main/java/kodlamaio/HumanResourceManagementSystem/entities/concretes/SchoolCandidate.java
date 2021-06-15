package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SchoolCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "school_department_id")
    private SchoolDepartment schoolDepartment;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name = "date_of_graduation")
    private LocalDate dateOfGraduation;

}
