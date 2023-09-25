package playwithjava.in.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import playwithjava.in.entity.StudentEntity;

import java.util.List;

public interface StudentRepository extends MongoRepository<StudentEntity,Long> {


    List<StudentEntity> findByName(String name);
    List<StudentEntity> findByNameAndEmail(String name,String email);
    List<StudentEntity> findByNameOrEmail(String name,String email);

    List<StudentEntity> findByAddressCity(String city);


}
