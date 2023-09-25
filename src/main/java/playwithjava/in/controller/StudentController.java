package playwithjava.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import playwithjava.in.bean.*;
import playwithjava.in.service.EmployeeService;
import playwithjava.in.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/stud")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("addStudent")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest request){
        log.info("REQ: "+request);
        StudentResponse emp =studentService.addStudent(request);
        log.info("Response: "+emp);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping("getStudentById/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id){
        StudentResponse studentResponse =studentService.getStudentById(id);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("getStudentByName/{name}")
    public ResponseEntity<List<StudentResponse>> getStudentByName(@PathVariable String name){
        List<StudentResponse> studentResponse =studentService.getStudentByName(name);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }


    @GetMapping("getStudentByNameAndEmail/{name}/{email}")
    public ResponseEntity<List<StudentResponse>> getStudentByNameAndEmail(@PathVariable String name,@PathVariable String email){
        List<StudentResponse> studentResponse =studentService.getStudentByNameAndEmail(name,email);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("getStudentByNameOrEmail/{name}/{email}")
    public ResponseEntity<List<StudentResponse>> getStudentByNameOrEmail(@PathVariable String name,@PathVariable String email){
        List<StudentResponse> studentResponse =studentService.getStudentByNameOrEmail(name,email);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("getStudentWithPagination/{pageNum}/{pageSize}")
    public ResponseEntity<List<StudentResponse>> getStudentByNameOrEmail(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        List<StudentResponse> studentResponse =studentService.getStudentWithPagination(pageNum,pageSize);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }


    @GetMapping("getStudentWithSorting")
    public ResponseEntity<List<StudentResponse>> getStudentByNameOrEmail(){
        List<StudentResponse> studentResponse =studentService.getStudentWithSorting();
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping("getStudentWithSortingDesc")
    public ResponseEntity<List<StudentResponse>> getStudentWithSortingDesc(){
        List<StudentResponse> studentResponse =studentService.getStudentWithSortingDesc();
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }



    @GetMapping("getStudentsByCity/{city}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCity(@PathVariable String city){
        List<StudentResponse> studentResponse =studentService.findStudentByCity(city);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }



    @PostMapping("addStudentWithRef")
    public ResponseEntity<StudentResponse> addStudentWithRef(@RequestBody StudentRequestWithRef request){
        log.info("REQ: "+request);
        StudentResponse emp =studentService.addStudentWithRef(request);
        log.info("Response: "+emp);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }


    @GetMapping("getStudentRefById/{id}")
    public ResponseEntity<List<StudentResponse>> getStudentRefById(@PathVariable Integer id){
        List<StudentResponse> studentResponse =studentService.getStudentRefById(id);
        log.info("Response: "+studentResponse);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }
}
