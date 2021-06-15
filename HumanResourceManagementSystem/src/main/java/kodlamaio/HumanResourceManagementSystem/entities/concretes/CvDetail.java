package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_details")
public class CvDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descripton")
    private String description;

    @Column(name = "cv_photo_url")
    private String cvPhotoUrl;

    @OneToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
