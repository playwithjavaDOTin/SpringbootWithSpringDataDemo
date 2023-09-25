package playwithjava.in.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import playwithjava.in.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity,Long> {
}
