package playwithjava.in.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employeeRoleWithRef")
public class EmployeeRoleWithRef {

    @Id
    private int roleId;
    private String roleName;
}
