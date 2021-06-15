package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolCandidateService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.SchoolCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/schoolcandidate")
public class SchoolCandidateController {

    private SchoolCandidateService schoolCandidateService;

    @Autowired
    public SchoolCandidateController(SchoolCandidateService schoolCandidateService) {
        this.schoolCandidateService = schoolCandidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.schoolCandidateService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SchoolCandidate schoolCandidate){
        return ResponseEntity.ok(this.schoolCandidateService.add(schoolCandidate));
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(schoolCandidateService.getByCandidateId(candidateId));
    }

    @GetMapping("/getByCandidateIdOrderByDateOfGraduationDesc")
    public ResponseEntity<?> getByCandidateIdOrderByDateOfGraduationDesc(int candidateId){
        return ResponseEntity.ok(schoolCandidateService.getByCandidateIdOrderByDateOfGraduationDesc(candidateId));
    }
}
