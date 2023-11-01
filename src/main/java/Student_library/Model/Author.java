package Student_library.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Name;
    @Column(unique = true,nullable = false)
    String email;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book>bookList = new ArrayList<>();
}
