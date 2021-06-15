package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.WorkplaceCandidate;

import java.util.List;

public interface WorkplaceCandidateService {
    DataResult<List<WorkplaceCandidate>> getAll();

    DataResult<List<WorkplaceCandidate>> getByCandidateId(int candidateId);

    DataResult<List<WorkplaceCandidate>> getByCandidateIdOrderByDateOfQuitDesc(int candidateId);

    Result add(WorkplaceCandidate workplaceCandidate);
}
