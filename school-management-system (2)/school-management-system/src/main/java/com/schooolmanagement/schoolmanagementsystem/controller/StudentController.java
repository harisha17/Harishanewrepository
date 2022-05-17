package com.schooolmanagement.schoolmanagementsystem.controller;
import com.schooolmanagement.schoolmanagementsystem.model.Student;
import com.schooolmanagement.schoolmanagementsystem.service.StudentServiceImpl;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Validated
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Operation(summary = "get Student details",description ="get a list of Student details", tags= "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return studentServiceImpl.getAllStudents();
    }
    @Operation(summary = "get Student details",description ="get a list of particular Student details", tags= "get")
    @ApiResponse(responseCode = "200", description = "Found the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id){

        return studentServiceImpl.getStudent(id);
    }


    @Operation(summary = "insert Student details",description ="Inserting  particular Student details", tags= "post")
    @ApiResponse(responseCode = "200", description = "Inserted the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @PostMapping("/insert")
    public String  addStudent(@RequestBody Student student) {

          studentServiceImpl.addStudent(student);
        return "Successfully Inserted";

    }

    @Operation(summary = "update the  Student details",description ="updating particular Student details", tags= "put")
    @ApiResponse(responseCode = "200", description = "updated the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @PatchMapping("/update/{id}")
    public String updateStudent(@RequestBody Student studentDetails){
        studentServiceImpl.updateStudent(studentDetails);
        return "successfully updated";
    }

    @Operation(summary = "Delete Student",description ="Delete a  particular Student details", tags= "delete")
    @ApiResponse(responseCode = "200", description = "deleted the Student", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @DeleteMapping("/delete/{id}")
    public  String deleteStudent(@PathVariable("id") int id){
        String delete = "successfully deleted";
        studentServiceImpl.deleteStudent(id);
        return delete ;
    }
    @Operation(summary = "validate Student details",description ="Validating Student details", tags= "post")
    @ApiResponse(responseCode = "200", description = "Validating the Student details", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))})

    @PostMapping("/student/")
    ResponseEntity<String> student(@Valid @RequestBody Student student) {
        return ResponseEntity.ok("Your id is " + student.getId());
    }
}
