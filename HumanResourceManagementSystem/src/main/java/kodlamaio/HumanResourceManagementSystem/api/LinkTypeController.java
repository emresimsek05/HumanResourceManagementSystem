package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LinkTypeService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LinkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/linktype")
public class LinkTypeController {
    private LinkTypeService linkTypeService;
    @Autowired
    public LinkTypeController(LinkTypeService linkTypeService) {
        this.linkTypeService = linkTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(linkTypeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LinkType linkType){
        return ResponseEntity.ok(linkTypeService.add(linkType));
    }
}
