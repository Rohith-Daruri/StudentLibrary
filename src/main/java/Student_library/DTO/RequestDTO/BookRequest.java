package Student_library.DTO.RequestDTO;

import Student_library.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {
    int Author_id;
    String name;
    int copies;
    int pages;
    Genre genre;
    double price;
}
