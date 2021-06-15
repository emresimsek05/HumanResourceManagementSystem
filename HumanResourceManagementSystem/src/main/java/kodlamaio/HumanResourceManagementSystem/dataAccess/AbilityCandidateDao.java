package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityCandidateDao extends JpaRepository<AbilityCandidate,Integer> {

    List<AbilityCandidate> getByCandidate_Id(int candidateId);
}
