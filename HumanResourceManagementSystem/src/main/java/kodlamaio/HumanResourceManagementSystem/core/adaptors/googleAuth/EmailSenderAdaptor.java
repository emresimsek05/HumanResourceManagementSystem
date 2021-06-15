package kodlamaio.HumanResourceManagementSystem.core.adaptors.googleAuth;

import kodlamaio.HumanResourceManagementSystem.ZEmailVerification.EmailSender;
import kodlamaio.HumanResourceManagementSystem.core.adaptors.EmailAdaptor;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderAdaptor implements EmailAdaptor {
    EmailSender emailSender1 = new EmailSender();


    @Override
    public boolean emailSend(String email) {
        return emailSender1.EmailVerification(email);
    }
}
