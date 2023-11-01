package Student_library.Transformer;

import Student_library.DTO.RequestDTO.BookRequest;
import Student_library.DTO.ResponseDTO.BookResponse;
import Student_library.Model.Book;

import java.util.ArrayList;

public class BookTransformer {
    public static Book RequestToModel(BookRequest bookRequest){
        return Book.builder()
                .name(bookRequest.getName())
                .copies(bookRequest.getCopies())
                .pages(bookRequest.getPages())
                .genre(bookRequest.getGenre())
                .price(bookRequest.getPrice())
                .transactionList(new ArrayList<>())
                .build();
    }
    public static BookResponse ModelToResponse(Book book){
        return BookResponse.builder()
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
