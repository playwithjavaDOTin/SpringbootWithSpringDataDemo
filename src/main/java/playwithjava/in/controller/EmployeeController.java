package playwithjava.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playwithjava.in.bean.EmployeeRequest;
import playwithjava.in.bean.EmployeeResponse;
import playwithjava.in.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("getALlEmployees")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){

        List<EmployeeResponse> allEmployees =employeeService.getAllEmployees();
        log.info("Response: "+allEmployees);
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }


    @GetMapping("addEmployee")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest){

        EmployeeResponse emp =employeeService.addEmployee(employeeRequest);
        log.info("Response: "+emp);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
