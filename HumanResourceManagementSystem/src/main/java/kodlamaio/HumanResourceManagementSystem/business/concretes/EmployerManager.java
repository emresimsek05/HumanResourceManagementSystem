package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.ActivationCodeService;
import kodlamaio.HumanResourceManagementSystem.business.abstracts.EmployerService;
import kodlamaio.HumanResourceManagementSystem.core.adaptors.EmailAdaptor;
import kodlamaio.HumanResourceManagementSystem.core.utilities.business.BusinessRules;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.*;
import kodlamaio.HumanResourceManagementSystem.dataAccess.EmployerDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailAdaptor adaptor;
    private ActivationCodeService activationCodeService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,EmailAdaptor adaptor,
             ActivationCodeService activationCodeService ){
        super();
        this.employerDao = employerDao;
        this.adaptor = adaptor;
        this.activationCodeService=activationCodeService;

    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"data listelendi");
    }

    @Override
    public Result add(Employer employer) {
        Result result = BusinessRules.run(emailExist(employer.getEmail()),nullControl(employer));

        if(result.isSuccess()) {

            employerDao.save(employer);
            activationCodeService.sendActivationCode(employer.getId());
            return new SuccessResult("eklendi");

        }
        return result;
    }

    private Result emailExist(String email) {
        if(employerDao.findAllByEmail(email).stream().count()!= 0) {
            return new ErrorResult("bu e mail mevcut");
        }
        return new SuccessResult();
    }

    private Result nullControl(Employer employer) {
        if(employer.getEmail()==null || employer.getEmail().isBlank()||
                employer.getPassword()==null||employer.getPassword().isBlank()||
                employer.getCompanyName()==null|| employer.getCompanyName().isBlank()||
                employer.getWebAddress()==null||employer.getWebAddress().isBlank()) {

            return new ErrorResult("bu alanlar boş bırakılamaz");
        }
        return new SuccessResult();
    }

    private Result isRealEmployer(Employer employer) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmail());

        if(!employer.getEmail().contains(employer.getWebAddress())) {
            return new ErrorResult("domain aynı değil");
        }
        else if(matcher.matches()) {
            return new ErrorResult("hata");
        }
        return new SuccessResult();
    }
}
