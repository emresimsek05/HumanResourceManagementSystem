package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.DepartmentService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.departmentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Department department){
        return ResponseEntity.ok(this.departmentService.add(department));
    }
}
