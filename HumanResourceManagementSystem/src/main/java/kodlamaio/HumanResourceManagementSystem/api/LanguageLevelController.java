package kodlamaio.HumanResourceManagementSystem.api;

import kodlamaio.HumanResourceManagementSystem.business.abstracts.LanguageLevelService;
import kodlamaio.HumanResourceManagementSystem.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languagelevel")
public class LanguageLevelController {
    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(languageLevelService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody LanguageLevel languageLevel) {
        return ResponseEntity.ok(languageLevelService.add(languageLevel));
    }
}
