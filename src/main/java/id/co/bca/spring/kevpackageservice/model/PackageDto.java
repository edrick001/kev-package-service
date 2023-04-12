package id.co.bca.spring.kevpackageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDto {
    private int id;
    private String name;
    private String description;
    private String amount;
}
