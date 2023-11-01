package Student_library.Model;

import Student_library.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int regNo;
   String name;
   @Column(unique = true,nullable = false)
   String Email;
   @Enumerated(EnumType.STRING)
   Gender gender;
   int age;
   @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
   Library_card libraryCard;

}
