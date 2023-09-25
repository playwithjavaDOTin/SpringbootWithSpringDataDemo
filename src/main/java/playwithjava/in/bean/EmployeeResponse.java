package playwithjava.in.bean;


import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class EmployeeResponse {
    private Long empId;
    private String name;
    private String desig;
    private Double salary;
}
