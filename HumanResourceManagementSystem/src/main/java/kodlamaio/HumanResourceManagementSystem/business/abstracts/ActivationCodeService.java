package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;

public interface ActivationCodeService {
    Result sendActivationCode(int userId);

    Result verified(String code);
}
