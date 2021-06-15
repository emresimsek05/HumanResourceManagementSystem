package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.LanguageCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageCandidateManager implements LanguageCandidateService {
    private LanguageCandidateDao languageCandidateDao;
    @Autowired
    public LanguageCandidateManager(LanguageCandidateDao languageCandidateDao) {
        this.languageCandidateDao = languageCandidateDao;
    }



    @Override
    public DataResult<List<LanguageCandidate>> getAll() {
        return new SuccessDataResult<List<LanguageCandidate>>(languageCandidateDao.findAll(),"İş aranan diller listelendi");
    }

    @Override
    public DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<LanguageCandidate>>(languageCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(LanguageCandidate languageCandiate) {
        languageCandidateDao.save(languageCandiate);
        return new SuccessResult("başarıyla eklendi");
    }
}
