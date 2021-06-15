package kodlamaio.HumanResourceManagementSystem.entities.dtos;

import kodlamaio.HumanResourceManagementSystem.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailsDto{

    private String companyName;
    private String title;
    private String cityName;
    private int quota;
   // private LocalDate applicationDeadline;
   // private LocalDateTime createdDate;

}
