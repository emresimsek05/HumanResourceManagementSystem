package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;

import java.util.List;

public interface SchoolCandidateService {
    DataResult<List<SchoolCandidate>> getAll();

    DataResult<List<SchoolCandidate>> getByCandidateId(int candidateId);

    DataResult<List<SchoolCandidate>> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId);

    Result add(SchoolCandidate schoolCandidate);
}
