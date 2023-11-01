package Student_library.DTO.RequestDTO;

import Student_library.Enum.Gender;
import Student_library.Enum.Genre;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    String name;
    String email;
    int age;
    Gender gender;

}
