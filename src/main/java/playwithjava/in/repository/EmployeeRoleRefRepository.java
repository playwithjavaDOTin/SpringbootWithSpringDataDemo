package playwithjava.in.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import playwithjava.in.entity.EmployeeRoleWithRef;
import playwithjava.in.entity.StudentEntityWithReference;

import java.util.List;

public interface EmployeeRoleRefRepository extends MongoRepository<EmployeeRoleWithRef,Integer> {

   // List<StudentEntityWithReference> findBy
}
