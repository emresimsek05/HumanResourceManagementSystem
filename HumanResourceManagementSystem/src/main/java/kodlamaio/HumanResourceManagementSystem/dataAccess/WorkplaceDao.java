package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkplaceDao extends JpaRepository<Workplace,Integer> {
}
