package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementDetailsDto;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();

    DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineAsc();

    DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int id);

    DataResult<List<JobAdvertisementDetailsDto>> getAdvertisementWithEmployerDetails();


    Result add(JobAdvertisement jobAdvertisement);

    Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement);
}
