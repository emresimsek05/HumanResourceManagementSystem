package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;

import java.util.List;

public interface LanguageCandidateService {
    DataResult<List<LanguageCandidate>> getAll();

    DataResult<List<LanguageCandidate>> getByCandidateId(int candidateId);

    Result add(LanguageCandidate languageCandidate);
}
