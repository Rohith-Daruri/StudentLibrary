package Student_library.Service;

import Student_library.DTO.RequestDTO.BookRequest;
import Student_library.DTO.ResponseDTO.BookResponse;
import Student_library.Model.Author;
import Student_library.Model.Book;
import Student_library.Repository.AuthorRepository;
import Student_library.Repository.BookRepository;
import Student_library.Transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public BookResponse addBook(BookRequest bookRequest,int id) {
        Book book = BookTransformer.RequestToModel(bookRequest);
        Author author = authorRepository.findById(id).get();
        book.setAuthor(author);
        Book saved_Book = bookRepository.save(book);
        author.getBookList().add(saved_Book);
        authorRepository.save(author);
        BookResponse bookResponse = BookTransformer.ModelToResponse(saved_Book);
        return bookResponse;
    }

}
