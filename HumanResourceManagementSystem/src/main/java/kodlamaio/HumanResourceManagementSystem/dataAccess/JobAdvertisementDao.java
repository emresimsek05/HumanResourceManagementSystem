package kodlamaio.HumanResourceManagementSystem.dataAccess;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> getByIsActiveTrue();

    List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadlineAsc();

    List<JobAdvertisement> getByIsActiveTrueAndEmployerId(int id);

    @Query("select new kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementDetailsDto(e.companyName, t.title, j.quota, c.cityName)" +
    "from JobAdvertisement j inner join j.employer e inner join j.jobTitle t inner join j.city c")

    List<JobAdvertisementDetailsDto> getAdvertisementWithEmployerDetails();
}
