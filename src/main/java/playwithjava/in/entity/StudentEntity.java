package playwithjava.in.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "student")
@Builder(toBuilder = true)

public class StudentEntity {

    @Id
    @Field(name = "id")
    private Long sid;

    @Field(name = "name")
    private String name;
    private String email;

    private AddressEntity address;
    private List<EmployeeRole> employeeRoles;

    public StudentEntity() {
    }

    public StudentEntity(String studentName) {
        this.name = studentName;
    }

    public StudentEntity(String studentName, String email) {
        this.name = studentName;
        this.email = email;
    }

    public StudentEntity(Long sid, String studentName, String email, AddressEntity address, List<EmployeeRole> employeeRoles) {
        this.sid = sid;
        this.name = studentName;
        this.email = email;
        this.address = address;
        this.employeeRoles = employeeRoles;
    }
}
