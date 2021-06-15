package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.AbilityCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.AbilityCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityCandidateManager implements AbilityCandidateService {
    private AbilityCandidateDao abilityCandidateDao;
    @Autowired
    public AbilityCandidateManager(AbilityCandidateDao abilityCandidateDao) {
        this.abilityCandidateDao = abilityCandidateDao;
    }


    @Override
    public DataResult<List<AbilityCandidate>> getAll() {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidateDao.findAll(),"kullanıcı yetenekleri listelendi");
    }

    @Override
    public DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<AbilityCandidate>>(abilityCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(AbilityCandidate abilityCandidate) {
        abilityCandidateDao.save(abilityCandidate);
        return new SuccessResult("BAŞARIYLA EKLENDİ");
    }
}
