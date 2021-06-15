package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.WorkplaceCandidateService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.WorkplaceCandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkPlaceCandidateManager implements WorkplaceCandidateService {
    private WorkplaceCandidateDao workplaceCandidateDao;
    @Autowired
    public WorkPlaceCandidateManager(WorkplaceCandidateDao workplaceCandidateDao){
        this.workplaceCandidateDao = workplaceCandidateDao;
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getAll() {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.findAll(), "data listelendi");
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.getByCandidate_Id(candidateId));
    }

    @Override
    public DataResult<List<WorkplaceCandidate>> getByCandidateIdOrderByDateOfQuitDesc(int candidateId) {
        return new SuccessDataResult<List<WorkplaceCandidate>>(workplaceCandidateDao.getByCandidate_IdOrderByDateOfQuitDesc(candidateId));
    }

    @Override
    public Result add(WorkplaceCandidate workplaceCandidate) {
        workplaceCandidateDao.save(workplaceCandidate);
        return new SuccessResult("başarıyla eklendi");
    }
}
