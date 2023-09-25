package playwithjava.in.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import playwithjava.in.entity.StudentEntity;
import playwithjava.in.entity.StudentEntityWithReference;

import java.util.List;

public interface StudentRepositoryWithRef extends MongoRepository<StudentEntityWithReference,Long> {




   List<StudentEntityWithReference> findByEmployeeRolesRoleId(Integer roleId);

   List<StudentEntityWithReference> findByEmployeeRolesRoleName(String name);


}
