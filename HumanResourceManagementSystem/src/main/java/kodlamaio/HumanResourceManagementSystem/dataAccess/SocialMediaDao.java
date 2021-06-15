package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaDao extends JpaRepository<SocialMedia,Integer> {

    List<SocialMedia> getByCandidate_Id(int candidateId);
}
