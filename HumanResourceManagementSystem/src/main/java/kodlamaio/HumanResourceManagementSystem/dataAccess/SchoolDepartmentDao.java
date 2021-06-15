package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment,Integer> {
}
