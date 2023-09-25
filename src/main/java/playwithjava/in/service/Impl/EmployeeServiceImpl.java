package playwithjava.in.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithjava.in.bean.EmployeeRequest;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;
import playwithjava.in.mapper.EmployeeMapperService;
import playwithjava.in.repository.EmployeeRepository;
import playwithjava.in.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapperService mapperService;


    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<EmployeeEntity> employeeResponses= employeeRepository.findAll();
        System.out.println("Entity :: "+employeeResponses);
        List<EmployeeResponse> data=employeeResponses.stream().map(mapperService::mapEmployeeEntityToResponse).collect(Collectors.toList());
        return data;
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        System.out.println("#############  Request :: "+employeeRequest);

        EmployeeEntity employeeEntity= mapperService.mapEmployeeReqToEntity(employeeRequest);
        System.out.println("######## employeeEntity "+employeeEntity);
        EmployeeEntity resp=employeeRepository.save(employeeEntity);

        return mapperService.mapEmployeeEntityToResponse(resp);
    }
}
