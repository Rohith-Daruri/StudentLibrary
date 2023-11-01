package Student_library.Service;

import Student_library.DTO.RequestDTO.TransactionRequest;
import Student_library.DTO.ResponseDTO.TransactionResponse;
import Student_library.Enum.TransactionStatus;
import Student_library.Exceptions.BookNotFoundException;
import Student_library.Model.Book;
import Student_library.Model.Library_card;
import Student_library.Model.Student;
import Student_library.Model.Transaction;
import Student_library.Repository.BookRepository;
import Student_library.Repository.StudentRepository;
import Student_library.Repository.TransactionRepository;
import Student_library.Transformer.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;
    public TransactionResponse addTransaction(int sid,int bid) throws Exception {
        Student student = studentRepository.findById(sid).get();
        Library_card libraryCard = student.getLibraryCard();
        libraryCard.setBooks_Taken(libraryCard.getBooks_Taken()+1);
        libraryCard.setBooks_withheld(libraryCard.getBooks_withheld()+1);
        Book book = bookRepository.findById(bid).get();
        if(book.getCopies()==0){
            throw new BookNotFoundException("Book Out Of STOCK!!!");
        }
        book.setCopies(book.getCopies()-1);
        Transaction transaction = new Transaction();
        transaction.setTransaction_Id(String.valueOf(UUID.randomUUID()));
        transaction.setTransactionStatus(TransactionStatus.IN_PROGRESS);
        transaction.setFine(10);
        transaction.setCard(libraryCard);
        transaction.setBook(book);
        Transaction saved_Transaction = transactionRepository.save(transaction);
        book.getTransactionList().add(saved_Transaction);
        libraryCard.getTransactionList().add(saved_Transaction);
        TransactionResponse transactionResponse = TransactionTransformer.ModelToResponse(saved_Transaction);
        return transactionResponse;
    }

    public void update_fine(int id, int amount) {
        Transaction transaction = transactionRepository.findById(id).get();
        transaction.setFine(amount);
        transactionRepository.save(transaction);
    }
}
