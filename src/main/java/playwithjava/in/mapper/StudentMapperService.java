package playwithjava.in.mapper;

import playwithjava.in.bean.*;
import playwithjava.in.entity.EmployeeEntity;
import playwithjava.in.entity.StudentEntity;
import playwithjava.in.entity.StudentEntityWithReference;

public interface StudentMapperService {

    StudentEntity mapStudentReqToEntity(StudentRequest request);
    StudentResponse mapStudentEntityToResponse(StudentEntity studentEntity);

    StudentEntityWithReference mapStudentRefReqToEntity(StudentRequestWithRef request);

    StudentResponse mapStudentEntityRefToResponse(StudentEntityWithReference request);
}
