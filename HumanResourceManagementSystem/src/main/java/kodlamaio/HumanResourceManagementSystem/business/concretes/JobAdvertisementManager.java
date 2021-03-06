package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobAdvertisementService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.business.BusinessRules;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.*;
import kodlamaio.HumanResourceManagementSystem.dataAccess.CityDao;
import kodlamaio.HumanResourceManagementSystem.dataAccess.EmployerDao;
import kodlamaio.HumanResourceManagementSystem.dataAccess.JobAdvertisementDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.JobAdvertisementDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;
    private EmployerDao employerDao;
    private CityDao cityDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmployerDao employerDao,CityDao cityDao){
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employerDao = employerDao;
        this.cityDao = cityDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {

        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"data listelendi");

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {

        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrue());

    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadlineAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActiveTrueOrderByApplicationDeadlineAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployerId(int id) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByIsActiveTrueAndEmployerId(id));
    }

    @Override
    public DataResult<List<JobAdvertisementDetailsDto>> getAdvertisementWithEmployerDetails() {
        return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails());
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {

        Result result = BusinessRules.run( employerControl(jobAdvertisement.getEmployer().getId()),
                cityControl(jobAdvertisement.getCity().getId()),
                NullControl(jobAdvertisement),
                minSalaryControl(jobAdvertisement),
                quotaControl(jobAdvertisement),
                minMaxControl(jobAdvertisement),
                minEqualsMaxControl(jobAdvertisement));

        if(result.isSuccess()) {

            jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("eklendi");

        }
        return result;
    }

    @Override
    public Result update(int jobAdvertisementId , JobAdvertisement jobAdvertisement) {

        Result result = BusinessRules.run(checkApplicationDeadline(jobAdvertisementId, jobAdvertisement));

        if(result.isSuccess()) {


            jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("ba??ar??yla g??ncellendi");

        }
        return result;


    }

    private Result employerControl(int id) {
        if(!employerDao.existsById(id)) {
            return new ErrorResult("b??yle bir kullan??c?? yok");
        }
        return new SuccessResult();
    }

    private Result cityControl(int id) {
        if(!cityDao.existsById(id)) {
            return new ErrorResult("b??yle bir ??ehir yok");
        }
        return new SuccessResult();
    }

    private Result NullControl(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getDescription() == null || jobAdvertisement.getDescription().isBlank()) {
            return new ErrorResult("i?? tan??m?? alan?? bo?? olamaz");
        }
        else if(jobAdvertisement.getMaxSalary() == null || jobAdvertisement.getMaxSalary() == null) {
            return new ErrorResult("maa?? alanlar?? doldurulmal??d??r");
        }
        else if(jobAdvertisement.getApplicationDeadline() == null) {
            return new ErrorResult("son ba??vuru tarihi bo?? b??rak??lamaz");
        }

        return new SuccessResult();
    }

    private Result minSalaryControl(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getMinSalary()<2820) {
            return new ErrorResult("minimum maa?? giri??i 2820 tl'den az olamaz");
        }
        return new SuccessResult();
    }

    private Result quotaControl(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getQuota()<1) {
            return new ErrorResult("a????k pozisyon adedi 1'den k??????k olamaz");
        }
        return new SuccessResult();
    }

    private Result minMaxControl(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getMinSalary()>jobAdvertisement.getMaxSalary()) {
            return new ErrorResult("minimum maa?? maximum maa??tan b??y??k olamaz");
        }
        return new SuccessResult();
    }

    private Result minEqualsMaxControl(JobAdvertisement jobAdvertisement) {
        if(jobAdvertisement.getMinSalary() == jobAdvertisement.getMaxSalary()) {
            return new ErrorResult("minimum maa?? maximum maa??a e??it olamaz");
        }
        return new SuccessResult();
    }



    //UPDATE

    private Result checkApplicationDeadline(int jobAdvertisementId, JobAdvertisement jobAdvertisement) {

        JobAdvertisement result = jobAdvertisementDao.findById(jobAdvertisementId).get();

        result.setActive(jobAdvertisement.isActive());



        if(jobAdvertisement.getApplicationDeadline().isBefore(LocalDate.now())) {
            return new ErrorResult("ilan??n tarihi ge??mi??");
        }
        return new SuccessResult();
    }
}
