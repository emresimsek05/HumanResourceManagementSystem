package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;

import java.util.List;

public interface LanguageLevelService {
    DataResult<List<LanguageLevel>> getAll();

    Result add(LanguageLevel languageLevel);
}
