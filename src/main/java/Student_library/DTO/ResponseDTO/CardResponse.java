package Student_library.DTO.ResponseDTO;

import Student_library.Enum.CardStatus;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponse {
    String Card_No;
    CardStatus cardStatus;
}
