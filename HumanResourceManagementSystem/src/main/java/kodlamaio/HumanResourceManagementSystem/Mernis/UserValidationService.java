package kodlamaio.HumanResourceManagementSystem.Mernis;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;

public interface UserValidationService {
    public boolean validate(Candidate candidate);
}
