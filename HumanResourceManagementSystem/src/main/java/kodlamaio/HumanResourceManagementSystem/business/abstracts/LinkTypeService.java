package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LinkType;

import java.util.List;

public interface LinkTypeService {
    DataResult<List<LinkType>> getAll();

    Result add(LinkType linkType);
}
