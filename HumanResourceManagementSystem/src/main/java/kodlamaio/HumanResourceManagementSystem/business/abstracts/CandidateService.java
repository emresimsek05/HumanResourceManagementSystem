package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);

    SuccessDataResult<CvDto> getCandidateCvByCandidateId(int candidateId);
}
