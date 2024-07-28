package com.example.lab5example1.Controller;

import com.example.lab5example1.API.APIController;
import com.example.lab5example1.Model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<Student>();
  @GetMapping("/get/students")
   public ArrayList<Student> getStudents() {
      return students;
  }
  @PostMapping("/add")
  public APIController addStudents(@RequestBody Student student){
      students.add(student);
      return new APIController("Successfully Added.");
  }
  @PutMapping("/update/{index}")
    public APIController updateStudents(@PathVariable int index,@RequestBody Student student) {
      students.add(index, student);
      return new APIController("Successfully Updated.");
  }
  @DeleteMapping ("/delete/{index}")
    public APIController deleteStudents(@PathVariable int index) {
      students.remove(index);
      return new APIController("Successfully Deleted.");
  }

  @GetMapping("/name/{index}")
    public APIController studentName(@PathVariable int index) {
      if(index < students.size()) {
          return new APIController("Name of student is "+ students.get(index).getName());
      }
      return new APIController("Student name not found");
      }

@GetMapping("/age/{index}")
public APIController studentAge(@PathVariable int index){
    if(index < students.size()){
        return new APIController("Age of student is " + students.get(index).getAge());
    }return  new APIController("Student age not found");
}
@GetMapping("/college/degree/{index}")
    public APIController studentDegree(@PathVariable int index){
      if(index < students.size()){
          return new APIController("Degree of students is " + students.get(index).getDegree());
      }
      return new APIController("Student college not found");
}
@GetMapping("/study/status/{index}")
    public APIController studentStatus(@PathVariable int index) {
    if(students.get(index).getStatus().equalsIgnoreCase("Graduated")){
        return new APIController("True");
    }return  new APIController("False");
}








}







