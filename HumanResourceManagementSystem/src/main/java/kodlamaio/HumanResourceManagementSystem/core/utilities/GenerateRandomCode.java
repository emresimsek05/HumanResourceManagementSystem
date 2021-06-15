package kodlamaio.HumanResourceManagementSystem.core.utilities;

import java.util.UUID;

public class GenerateRandomCode {
    public static UUID generateCode(){
        UUID code = UUID.randomUUID();
        return code;
    }
}
