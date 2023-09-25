package playwithjava.in.mapper;

import playwithjava.in.bean.EmployeeRequest;

import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;

public interface EmployeeMapperService {

    EmployeeEntity mapEmployeeReqToEntity(EmployeeRequest request);
    EmployeeResponse mapEmployeeEntityToResponse(EmployeeEntity request);
}
