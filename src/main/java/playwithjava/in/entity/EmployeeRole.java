package playwithjava.in.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRole {
    private String roleName;
    private int roleId;
}
