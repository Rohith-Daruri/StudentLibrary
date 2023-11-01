package Student_library.Controller;

import Student_library.DTO.RequestDTO.AuthorRequest;
import Student_library.Model.Author;
import Student_library.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorRequest authorRequest){
        Author author = authorService.addAuthor(authorRequest);
        return new ResponseEntity(author, HttpStatus.CREATED);
    }
}
