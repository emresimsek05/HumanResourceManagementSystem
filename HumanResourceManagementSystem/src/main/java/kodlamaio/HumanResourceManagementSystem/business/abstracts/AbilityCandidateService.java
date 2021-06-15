package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.AbilityCandidate;

import java.util.List;

public interface AbilityCandidateService {
    DataResult<List<AbilityCandidate>> getAll();

    DataResult<List<AbilityCandidate>> getByCandidateId(int candidateId);

    Result add(AbilityCandidate abilityCandidate);
}
