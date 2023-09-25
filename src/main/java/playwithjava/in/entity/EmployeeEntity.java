package playwithjava.in.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
@Builder(toBuilder = true)
public class EmployeeEntity {

    @Id
    private Long empId;
    private String name;
    private String desig;
    private Double salary;
}


