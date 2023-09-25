package playwithjava.in.service;

import playwithjava.in.bean.EmployeeRequest;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

List<EmployeeResponse> getAllEmployees();

EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

}
