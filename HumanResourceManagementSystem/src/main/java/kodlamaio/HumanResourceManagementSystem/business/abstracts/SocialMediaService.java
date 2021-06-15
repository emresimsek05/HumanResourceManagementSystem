package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;

import java.util.List;

public interface SocialMediaService {
    DataResult<List<SocialMedia>> getAll();

    Result add(SocialMedia socialMedia);

    DataResult<List<SocialMedia>> getByCandidateId(int candidateId);
}
