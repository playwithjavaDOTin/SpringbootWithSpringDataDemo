package playwithjava.in.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithjava.in.bean.*;
import playwithjava.in.entity.EmployeeEntity;
import playwithjava.in.entity.StudentEntity;
import playwithjava.in.entity.StudentEntityWithReference;


@Service
public class StudentMapperServiceImpl implements StudentMapperService{

    @Autowired
    ModelMapper mapper;


    @Override
    public StudentEntity mapStudentReqToEntity(StudentRequest request) {
        StudentEntity studentEntity=new StudentEntity();
        mapper.map(request,studentEntity);
        return studentEntity;
    }

    @Override
    public StudentResponse mapStudentEntityToResponse(StudentEntity studentEntity) {
        StudentResponse studentResponse=StudentResponse.builder().build();
        mapper.map(studentEntity,studentResponse);
        return studentResponse;
    }


    @Override
    public StudentEntityWithReference mapStudentRefReqToEntity(StudentRequestWithRef request) {
        StudentEntityWithReference studentEntity=new StudentEntityWithReference();
        mapper.map(request,studentEntity);
        return studentEntity;
    }

    @Override
    public StudentResponse mapStudentEntityRefToResponse(StudentEntityWithReference entity) {
        StudentResponse studentResponse=StudentResponse.builder().build();
        mapper.map(entity,studentResponse);
        return studentResponse;
    }
}
