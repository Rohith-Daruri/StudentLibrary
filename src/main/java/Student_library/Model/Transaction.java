package Student_library.Model;

import Student_library.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Transaction_Id;
    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;
    int Fine;
    @CreationTimestamp
    Date transactionDate;
    @ManyToOne
    @JoinColumn
    Library_card card;
    @ManyToOne
    @JoinColumn
    Book book;
}
