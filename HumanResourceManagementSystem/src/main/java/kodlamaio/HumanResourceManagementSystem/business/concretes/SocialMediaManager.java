package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SocialMediaService;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;
import kodlamaio.HumanResourceManagementSystem.dataAccess.SocialMediaDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaManager implements SocialMediaService {
   private SocialMediaDao socialMediaDao;

   @Autowired
   public SocialMediaManager(SocialMediaDao socialMediaDao){
       this.socialMediaDao = socialMediaDao;
   }
    @Override
    public DataResult<List<SocialMedia>> getAll() {
        return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll(), "listelendi");
    }

    @Override
    public Result add(SocialMedia socialMedia) {
       socialMediaDao.save(socialMedia);
       return new SuccessResult("başarıyla eklendi");
    }

    @Override
    public DataResult<List<SocialMedia>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.getByCandidate_Id(candidateId));
    }
}
