package Student_library.Controller;

import Student_library.DTO.RequestDTO.StudentRequest;
import Student_library.DTO.ResponseDTO.StudentResponse;
import Student_library.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
        try {
            StudentResponse studentResponse = studentService.addStudent(studentRequest);
            return new ResponseEntity(studentResponse,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
}
