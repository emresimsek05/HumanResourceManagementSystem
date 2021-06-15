package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.JobAdvertisementService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAll());
    }

    @GetMapping("/getAllByIsActiveTrue")
    public ResponseEntity<?> getAllByIsActiveTrue(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByIsActiveTrue());
    }

    @GetMapping("/getByisActiveTrueOrderByApplicationDeadlineAsc")
    public ResponseEntity<?> getByisActiveTrueOrderByApplicationDeadlineAsc(){
        return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrueOrderByApplicationDeadlineAsc());
    }

    @GetMapping("/getByisActiveTrueAndEmployerId")
    public ResponseEntity<?> getByIsActiveTrueAndEmployerId(int id){
        return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrueAndEmployerId(id));
    }

    @GetMapping("/getAdvertisementWithEmployerDetails")
    public ResponseEntity<?> getAdvertisementWithEmployerDetails(){
        return ResponseEntity.ok(this.jobAdvertisementService.getAdvertisementWithEmployerDetails());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int id,@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.update(id , jobAdvertisement));
    }
}
