package playwithjava.in.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import playwithjava.in.bean.*;
import playwithjava.in.entity.*;
import playwithjava.in.mapper.EmployeeMapperService;
import playwithjava.in.mapper.StudentMapperService;
import playwithjava.in.repository.EmployeeRepository;
import playwithjava.in.repository.EmployeeRoleRefRepository;
import playwithjava.in.repository.StudentRepository;
import playwithjava.in.repository.StudentRepositoryWithRef;
import playwithjava.in.service.EmployeeService;
import playwithjava.in.service.StudentService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    StudentRepositoryWithRef studentRepositoryWithRef;

    @Autowired
    StudentMapperService mapperService;

    @Autowired
    EmployeeRoleRefRepository employeeRoleRefRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        System.out.println("Entity :: " + studentEntities);
        List<StudentResponse> data = studentEntities.stream().map(mapperService::mapStudentEntityToResponse).collect(Collectors.toList());
        return data;
    }

/*
    @Override
    public StudentResponse addStudent(StudentRequest request) {
        System.out.println("#############  Request :: " + request);
        StudentEntity studentEntity = mapperService.mapStudentReqToEntity(request);
        System.out.println("######## employeeEntity " + studentEntity);
        StudentEntity resp = studentRepository.save(studentEntity);

        return mapperService.mapStudentEntityToResponse(resp);
    }
*/


    @Override
    public StudentResponse addStudent(StudentRequest request) {
        System.out.println("#############  Request :: " + request);
        StudentEntity studentEntity = mapperService.mapStudentReqToEntity(request);
        System.out.println("######## employeeEntity " + studentEntity);
        StudentEntity resp = studentRepository.save(studentEntity);

        return mapperService.mapStudentEntityToResponse(resp);
    }


    @Override
    public StudentResponse getStudentById(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        return mapperService.mapStudentEntityToResponse(studentEntity.get());
    }


    @Override
    public List<StudentResponse> getStudentByName(String name) {
        log.info("## NAME :: " + name);
        return convertStudentEntitiesToResponse(studentRepository.findByName(name));
    }

    @Override
    public List<StudentResponse> getStudentByNameAndEmail(String name, String email) {
        log.info("## NAME :: " + name);
        log.info("## EMAIL :: " + email);
        return convertStudentEntitiesToResponse(studentRepository.findByNameAndEmail(name, email));
    }

    @Override
    public List<StudentResponse> getStudentByNameOrEmail(String name, String email) {
        log.info("## NAME :: " + name);
        log.info("## EMAIL :: " + email);
        return convertStudentEntitiesToResponse(studentRepository.findByNameOrEmail(name, email));
    }

    @Override
    public List<StudentResponse> getStudentWithPagination(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return studentRepository.findAll(pageable).get()
                .map(mapperService::mapStudentEntityToResponse)
                .collect(Collectors.toList());

/*
        studentRepository.findAll(PageRequest.of(pageNum, pageSize))
                .get()
                .map(mapperService::mapStudentEntityToResponse)
                .collect(Collectors.toList());
*/

    }

    @Override
    public List<StudentResponse> getStudentWithSorting() {

/*      return studentRepository.findAll(sort)
                .stream()
                .map(mapperService::mapStudentEntityToResponse)
                .collect(LinkedList::new,LinkedList::add,LinkedList::addAll);*/
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return convertStudentEntitiesToResponse(studentRepository.findAll(sort));
    }


    @Override
    public List<StudentResponse> getStudentWithSortingDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return convertStudentEntitiesToResponse(studentRepository.findAll(sort));
    }


    private StudentResponse getResponse(StudentEntity studentEntity) {
        return mapperService.mapStudentEntityToResponse(studentEntity);
    }

    private List<StudentResponse> convertStudentEntitiesToResponse(List<StudentEntity> entities) {

        return entities.stream()
                .map(mapperService::mapStudentEntityToResponse)
                .collect(Collectors.toList());
    }


    @Override
    public List<StudentResponse> findStudentByCity(String city) {
        List<StudentEntity> studentEntities = studentRepository.findByAddressCity(city);

        return convertStudentEntitiesToResponse(studentEntities);
    }


    @Override
    public StudentResponse addStudentWithRef(StudentRequestWithRef request) {

        List<EmployeeRoleWithRef> employeeRoleWithRefs = request.getEmployeeRoles();
        employeeRoleRefRepository.saveAll(employeeRoleWithRefs);
        StudentEntityWithReference studentEntityWithReference = mapperService.mapStudentRefReqToEntity(request);
        studentRepositoryWithRef.save(studentEntityWithReference);

        return null;//convert entity to resp and return
    }

    @Override
    public List<StudentResponse> getStudentRefById(Integer id) {

        System.out.println("##########" + studentRepositoryWithRef.findByEmployeeRolesRoleId(id));
        return studentRepositoryWithRef.findByEmployeeRolesRoleId(id).stream()
                .map(mapperService::mapStudentEntityRefToResponse)
                .collect(Collectors.toList());


    }

}
