package kodlamaio.HumanResourceManagementSystem.Mernis;

import kodlamaio.HumanResourceManagementSystem.entities.concretes.Candidate;

public class UserValidationManager implements UserValidationService{
    @Override
    public boolean validate(Candidate candidate) {
        if (candidate.getFirstName()=="emre" && candidate.getIdentificationNumber()=="24681357901"){
            return true;
        }else {
            return false;
        }


    }
}
