package kodlamaio.HumanResourceManagementSystem.configurations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(
                ObjectUtils.asMap("cloud_name","ŞimşekCompany\",\n" +
                        "                        \"api_key\", \"281599122579737\",\n" +
                        "                        \"api_secret\",\"7WyBadrMwFnDk86SUnwJnjVdrN8\"")
        );
    }
}
