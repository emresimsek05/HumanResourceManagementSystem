package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobTitleService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobTitle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/titles")
public class JobTitleController {
    private JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService){
        super();
        this.jobTitleService = jobTitleService;
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobTitleService.getAll());
    }
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle){
        return ResponseEntity.ok(this.jobTitleService.add(jobTitle));
    }

}
