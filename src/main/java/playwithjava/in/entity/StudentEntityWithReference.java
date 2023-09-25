package playwithjava.in.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "studentWithRef")
public class StudentEntityWithReference {

    @Id
    @Field(name = "id")
    private Long sid;

    @Field(name = "name")
    private String name;

    private String email;


    private AddressEntity address;

    @DBRef(lazy = true)
    private List<EmployeeRoleWithRef> employeeRoles;

    public StudentEntityWithReference() {
    }

    public StudentEntityWithReference(String studentName) {
        this.name = studentName;
    }

    public StudentEntityWithReference(String studentName, String email) {
        this.name = studentName;
        this.email = email;
    }

    public StudentEntityWithReference(Long sid, String studentName, String email, AddressEntity address, List<EmployeeRoleWithRef> employeeRoles) {
        this.sid = sid;
        this.name = studentName;
        this.email = email;
        this.address = address;
        this.employeeRoles = employeeRoles;
    }
}
