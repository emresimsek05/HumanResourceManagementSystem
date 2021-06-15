package kodlamaio.HumanResourceManagementSystem.core.utilities.ımageHelpers;

import kodlamaio.HumanResourceManagementSystem.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUpload {
    DataResult<Map> upload(MultipartFile multipartFile);
}
