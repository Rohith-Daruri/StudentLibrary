package Student_library.Transformer;

import Student_library.DTO.RequestDTO.StudentRequest;
import Student_library.DTO.ResponseDTO.StudentResponse;
import Student_library.Model.Student;

public class StudentTransformer {
    public static Student RequestToModel(StudentRequest studentRequest){
        return Student.builder()
                .name(studentRequest.getName())
                .Email(studentRequest.getEmail())
                .age(studentRequest.getAge())
                .gender(studentRequest.getGender())
                .build();
    }
}
