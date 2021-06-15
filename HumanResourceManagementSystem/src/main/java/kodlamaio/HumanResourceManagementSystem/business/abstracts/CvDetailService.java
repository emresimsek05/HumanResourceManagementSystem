package kodlamaio.HumanResourceManagementSystem.business.abstracts;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvDetailService {
    DataResult<List<CvDetail>> getAll();

    DataResult<CvDetail> getByCandidateId(int candidateId);

    Result add(CvDetail cvDetail);

    Result uploadPhoto(MultipartFile file, int candidateId);

}
