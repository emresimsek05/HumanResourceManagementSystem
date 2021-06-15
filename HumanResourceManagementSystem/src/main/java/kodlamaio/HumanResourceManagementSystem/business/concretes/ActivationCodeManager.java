package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.ActivationCodeService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.GenerateRandomCode;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.ActivationCodeDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivationCodeManager implements ActivationCodeService {
    private ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(){
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public Result sendActivationCode(int userId) {
       String code = GenerateRandomCode.generateCode().toString();
       activationCodeDao.save(new ActivationCode(userId,code,false,null));
        return new SuccessResult("başarılı");
    }

    @Override
    public Result verified(String code) {
       ActivationCode activationCode = activationCodeDao.findByCode(code);
       activationCode.setVerified(true);
       activationCode.setVerifiedDate(LocalDateTime.now());
       activationCodeDao.save(activationCode);
        return new SuccessResult("başarılı");
    }
}
