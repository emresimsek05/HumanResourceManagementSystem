package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolCandidateDao extends JpaRepository<SchoolCandidate,Integer> {

    List<SchoolCandidate> getByCandidate_Id(int candidateId);

    List<SchoolCandidate> getByCandidate_IdOrderByDateOfGraduationDesc(int candidateId);

}
