package kodlamaio.HumanResourceManagementSystem.core.utilities.business;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.Result;
import kodlamaio.HumanResourceManagementSystem.core.utilities.results.SuccessResult;

public class BusinessRules {

    public static Result run(Result... logics){
        for (Result logic:logics){
            if (!logic.isSuccess()){
                return logic;
            }
        }
            return new SuccessResult();
    }
}
