package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityDao extends JpaRepository<Ability,Integer> {
}
