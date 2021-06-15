package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDetailDao extends JpaRepository<CvDetail,Integer> {

    CvDetail getByCandidate_Id(int candidateId);
}
