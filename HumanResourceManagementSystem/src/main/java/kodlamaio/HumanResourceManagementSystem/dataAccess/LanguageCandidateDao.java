package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageCandidateDao extends JpaRepository<LanguageCandidate,Integer> {

    List<LanguageCandidate> getByCandidate_Id(int candidateId);
}
