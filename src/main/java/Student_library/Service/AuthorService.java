package Student_library.Service;

import Student_library.DTO.RequestDTO.AuthorRequest;
import Student_library.Model.Author;
import Student_library.Repository.AuthorRepository;
import Student_library.Transformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author addAuthor(AuthorRequest authorRequest) {
        Author author = AuthorTransformer.RequestToModel(authorRequest);
        return authorRepository.save(author);
    }
}
