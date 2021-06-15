package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageCandidateService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languagecandidate")
public class LanguageCandidateController {
    private LanguageCandidateService languageCandidateService;

    @Autowired
    public LanguageCandidateController(LanguageCandidateService languageCandidateService) {
        this.languageCandidateService = languageCandidateService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(languageCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageCandidate languageCandiate){
        return ResponseEntity.ok(languageCandidateService.add(languageCandiate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(languageCandidateService.getByCandidateId(candidateId));
    }
}
