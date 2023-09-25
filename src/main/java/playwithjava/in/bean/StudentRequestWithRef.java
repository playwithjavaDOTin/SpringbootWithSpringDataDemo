package playwithjava.in.bean;

import lombok.Builder;
import lombok.Data;
import playwithjava.in.entity.EmployeeRole;
import playwithjava.in.entity.EmployeeRoleWithRef;

import java.util.List;


@Data
@Builder(toBuilder = true)
public class StudentRequestWithRef {
    private Long sid;
    private String name;
    private String email;

    private Address address;
    private List<EmployeeRoleWithRef> employeeRoles;
}
