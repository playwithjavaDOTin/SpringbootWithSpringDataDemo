package playwithjava.in.service;

import playwithjava.in.bean.*;

import java.util.List;

public interface StudentService {


    List<StudentResponse> getAllStudents();

    StudentResponse addStudent(StudentRequest request);

    StudentResponse getStudentById(Long id);

    List<StudentResponse> getStudentByName(String name);

    List<StudentResponse> getStudentByNameAndEmail(String name, String email);

    List<StudentResponse> getStudentByNameOrEmail(String name, String email);

    List<StudentResponse> getStudentWithPagination(Integer pageNum, Integer pageSize);

    List<StudentResponse> getStudentWithSorting();

    public List<StudentResponse> getStudentWithSortingDesc();

    List<StudentResponse> findStudentByCity(String city);


    StudentResponse addStudentWithRef(StudentRequestWithRef request);

    public List<StudentResponse> getStudentRefById(Integer id);

}
