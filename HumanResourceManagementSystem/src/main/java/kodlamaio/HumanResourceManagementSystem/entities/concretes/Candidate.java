package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.HumanResourceManagementSystem.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler",
        "schoolCandidates","languageCandidates",
        "abilityCandidates","workplaceCandidates",
        "socialMedias","cvDetail"})
public class Candidate extends User {
    @NotBlank
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NotNull
    @Column(name = "identity_number")
    private String identificationNumber;

    @NotNull
    @NotBlank
    @Column(name = "birth_date")
    private Date birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<SchoolCandidate> schoolCandidates;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<LanguageCandidate> languageCandidates;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<AbilityCandidate> abilityCandidates;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<WorkplaceCandidate> workplaceCandidates;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<SocialMedia> socialMedias;

    @JsonIgnore
    @OneToOne(mappedBy = "candidate" )
    private CvDetail cvDetail;

}
