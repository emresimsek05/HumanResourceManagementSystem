package kodlamaio.HumanResourceManagementSystem.business.concretes;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.*;
import kodlamaio.HumanResourceManagementSystem.core.utilities.business.BusinessRules;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.*;
import kodlamaio.HumanResourceManagementSystem.dataAccess.CandidateDao;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;
import kodlamaio.HumanResourceManagementSystem.entities.dtos.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private WorkplaceCandidateService workplaceCandidateService;
    private SchoolCandidateService schoolCandidateService;
    private LanguageCandidateService languageCandidateService;
    private SocialMediaService socialMediaService;
    private AbilityCandidateService abilityCandidateService;
    private CvDetailService cvDetailService;
    private ActivationCodeService activationCodeService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao,
    WorkplaceCandidateService workplaceCandidateService,
    SocialMediaService socialMediaService,
    CvDetailService cvDetailService,
    SchoolCandidateService schoolCandidateService,
    LanguageCandidateService languageCandidateService,
    AbilityCandidateService abilityCandidateService,
    ActivationCodeService activationCodeService) {

        this.candidateDao = candidateDao;
        this.workplaceCandidateService = workplaceCandidateService;
        this.socialMediaService = socialMediaService;
        this.schoolCandidateService = schoolCandidateService;
        this.languageCandidateService = languageCandidateService;
        this.abilityCandidateService = abilityCandidateService;
        this.cvDetailService = cvDetailService;
        this.activationCodeService =activationCodeService;

    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "data listelendi");
    }

    @Override
    public Result add(Candidate candidate) {
        Result result = BusinessRules.run(identityNumberControl(candidate));
        if (result.isSuccess()){
            candidateDao.save(candidate);
            activationCodeService.sendActivationCode(candidate.getId());
            return new SuccessResult("eklendi");
        }
        return result;
    }

    @Override
    public SuccessDataResult<CvDto> getCandidateCvByCandidateId(int candidateId) {
        CvDto cvDto = new CvDto();
        cvDto.setCandidate(this.candidateDao.findById(candidateId).get());
        cvDto.setAbilityCandidates(this.abilityCandidateService.getByCandidateId(candidateId).getData());
        cvDto.setLanguageCandidates(this.languageCandidateService.getByCandidateId(candidateId).getData());
        cvDto.setSchoolCandidates(this.schoolCandidateService.getByCandidateId(candidateId).getData());
        cvDto.setWorkplaceCandidates(this.workplaceCandidateService.getByCandidateId(candidateId).getData());
        cvDto.setSocialMedias(this.socialMediaService.getByCandidateId(candidateId).getData());
        cvDto.setCvDetail(this.cvDetailService.getByCandidateId(candidateId).getData());
        return  new SuccessDataResult <CvDto>(cvDto, "Cv getirildi");
    }

    private Result identityNumberControl(Candidate candidate) {

        if (candidate.getIdentificationNumber().length() != 11) {
            return new ErrorResult("Tc numarası 11 haneli olmalıdır.");
        }
        return new SuccessResult();
    }
}
