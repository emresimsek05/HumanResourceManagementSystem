package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.SchoolCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolCandidateManager implements SchoolCandidateService {
    private SchoolCandidateDao schoolCandidateDao;
    @Autowired
    public SchoolCandidateManager(SchoolCandidateDao schoolCandidateDao) {
        this.schoolCandidateDao = schoolCandidateDao;
    }

    @Override
    public DataResult<List<SchoolCandidate>> getAll() {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.findAll());
    }

    @Override
    public DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(SchoolCandidate schoolCandidate) {
        schoolCandidateDao.save(schoolCandidate);
        return new SuccessResult("eklendi");
    }

    @Override
    public DataResult<List<SchoolCandidate>> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId) {
        return new SuccessDataResult<List<SchoolCandidate>>(schoolCandidateDao.getByCandidate_IdOrderByDateOfGraduationDesc(candidateId));
    }
}
