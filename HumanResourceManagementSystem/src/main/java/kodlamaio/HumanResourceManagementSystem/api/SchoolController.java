package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.SchoolService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.schoolService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody School school){
        return ResponseEntity.ok(this.schoolService.add(school));
    }
}
