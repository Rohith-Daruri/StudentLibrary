package Student_library.Transformer;

import Student_library.DTO.ResponseDTO.BookResponse;
import Student_library.DTO.ResponseDTO.CardResponse;
import Student_library.DTO.ResponseDTO.TransactionResponse;
import Student_library.Model.Transaction;

public class TransactionTransformer {
    public static TransactionResponse ModelToResponse(Transaction transaction){
        BookResponse bookResponse = BookResponse.builder()
                .price(transaction.getBook().getPrice())
                .name(transaction.getBook().getName())
                .build();
        CardResponse cardResponse = CardResponse.builder()
                .Card_No(transaction.getCard().getCard_no())
                .cardStatus(transaction.getCard().getCardStatus())
                .build();
        return TransactionResponse.builder()
                .fine(transaction.getFine())
                .bookResponse(bookResponse)
                .cardResponse(cardResponse)
                .build();
    }
}
