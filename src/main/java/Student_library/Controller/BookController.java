package Student_library.Controller;

import Student_library.DTO.RequestDTO.BookRequest;
import Student_library.DTO.ResponseDTO.BookResponse;
import Student_library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add/{id}")
    public ResponseEntity addBook(@RequestBody BookRequest bookRequest,@PathVariable("id") int id){
        BookResponse bookResponse = bookService.addBook(bookRequest,id);
        return new ResponseEntity(bookResponse, HttpStatus.CREATED);
    }

}
