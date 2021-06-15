package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CvDetailService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.ımageHelpers.ImageUpload;
import kodlamaio.HumanResourceManagementSystem.dataAccess.CvDetailDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CvDetailManager implements CvDetailService {
    private CvDetailDao cvDetailDao;
    private ImageUpload imageUpload;

    @Autowired
    public CvDetailManager(CvDetailDao cvDetailDao , ImageUpload imageUpload){
        this.imageUpload = imageUpload;
        this.cvDetailDao = cvDetailDao;
    }

    @Override
    public DataResult<List<CvDetail>> getAll() {
        return new SuccessDataResult<List<CvDetail>>(cvDetailDao.findAll());
    }

    @Override
    public DataResult<CvDetail> getByCandidateId(int candidateId) {
        return new SuccessDataResult<CvDetail>(cvDetailDao.getByCandidate_Id(candidateId));
    }

    @Override
    public Result add(CvDetail cvDetail) {
        cvDetailDao.save(cvDetail);
        return new SuccessResult("başarıyla eklendi");
    }

    @Override
    public Result uploadPhoto(MultipartFile file, int candidateId) {
        CvDetail cvDetail = getByCandidateId(candidateId).getData();
        Map<String,String> result =(Map<String, String>) imageUpload.upload(file).getData();
        String url = result.get("url");
        cvDetail.setCvPhotoUrl(url);
        cvDetailDao.save(cvDetail);
        return new SuccessResult("başarılı");
    }
}
