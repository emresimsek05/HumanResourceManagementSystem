package kodlamaio.HumanResourceManagementSystem.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.HumanResourceManagementSystem.entities.abstracts.Dto;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {
    @JsonIgnore

    private Candidate candidate;
    private List<SchoolCandidate> schoolCandidates;
    private List<WorkplaceCandidate> workplaceCandidates;
    private List<AbilityCandidate> abilityCandidates;
    private List<LanguageCandidate> languageCandidates;
    private List<SocialMedia> socialMedias;
    private CvDetail cvDetail;

}
