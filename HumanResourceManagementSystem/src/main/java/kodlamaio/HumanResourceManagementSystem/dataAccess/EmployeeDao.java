package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
