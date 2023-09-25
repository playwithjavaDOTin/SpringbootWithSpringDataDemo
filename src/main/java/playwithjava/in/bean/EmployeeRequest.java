package playwithjava.in.bean;


import lombok.Data;

@Data
public class EmployeeRequest {
    private Long empId;
    private String name;
    private String desig;
    private Double salary;
}
