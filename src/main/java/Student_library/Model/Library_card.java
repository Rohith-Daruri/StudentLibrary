package Student_library.Model;

import Student_library.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Library_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String card_no;
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;
    @CreationTimestamp
    Date IssueDate;
    int Books_Taken;
    int Books_Returned;
    int Books_withheld;
    @JoinColumn
    @OneToOne
    Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();
}
