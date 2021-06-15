package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobTitleService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.business.BusinessRules;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.*;
import kodlamaio.HumanResourceManagementSystem.dataAccess.JobTitleDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao){
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Data Listelendi");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        Result result = BusinessRules.run(nullControl(jobTitle), titleRepeatControl(jobTitle));
        if (result.isSuccess()){
            jobTitleDao.save(jobTitle);
            return new SuccessResult("Eklendi");
        }
        return result;
    }

    private Result nullControl(JobTitle jobTitle){
        if (jobTitle.getTitle()==null || jobTitle.getTitle().isBlank()){
            return new ErrorResult("Alanları boş bırakmayınız");
        }
            return new SuccessResult();
    }

    private Result titleRepeatControl(JobTitle jobTitle){
        if (jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count() != 0){
            return new ErrorResult("Bu pozisyon mecuttur");
        }
            return new SuccessResult();
    }
}
