package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Workplace;

import java.util.List;

public interface WorkplaceService {
    DataResult<List<Workplace>> getAll();

    Result add(Workplace workplace);
}
