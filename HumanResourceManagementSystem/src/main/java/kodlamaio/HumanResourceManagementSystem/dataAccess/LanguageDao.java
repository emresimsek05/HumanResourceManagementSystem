package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
