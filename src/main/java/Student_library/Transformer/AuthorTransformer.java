package Student_library.Transformer;

import Student_library.DTO.RequestDTO.AuthorRequest;
import Student_library.Model.Author;

import java.util.ArrayList;

public class AuthorTransformer {
    public static Author RequestToModel(AuthorRequest authorRequest){
        return Author.builder()
                .Name(authorRequest.getName())
                .email(authorRequest.getEmail())
                .bookList(new ArrayList<>())
                .build();
    }
}
