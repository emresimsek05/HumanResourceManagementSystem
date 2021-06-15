package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.CvDetailService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.CvDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cvdetails")
public class CvDetailController {
    private CvDetailService cvDetailService;
    @Autowired
    public CvDetailController(CvDetailService cvDetailService) {
        this.cvDetailService = cvDetailService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(cvDetailService.getAll());
    }

    @GetMapping("/getByCandidateId")
    public ResponseEntity<?> getByCandidateId(int candidateId){
        return ResponseEntity.ok(cvDetailService.getByCandidateId(candidateId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CvDetail cvDetail) {
        return ResponseEntity.ok(cvDetailService.add(cvDetail));
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPhoto(@RequestParam("file") MultipartFile file, @RequestParam int candidateId) {
        return ResponseEntity.ok(cvDetailService.uploadPhoto(file,candidateId));
    }
}
