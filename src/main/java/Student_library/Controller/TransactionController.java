package Student_library.Controller;

import Student_library.DTO.RequestDTO.TransactionRequest;
import Student_library.DTO.ResponseDTO.BookResponse;
import Student_library.DTO.ResponseDTO.TransactionResponse;
import Student_library.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add/{sid}/{bid}")
    public ResponseEntity addTransaction(@PathVariable("sid") int sid,@PathVariable("bid") int bid){
        try{
            TransactionResponse transactionResponse = transactionService.addTransaction(sid,bid);
            return new ResponseEntity(transactionResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}/{amount}")
    public ResponseEntity update_fine(@PathVariable("id") int id,@PathVariable("amount") int amount){
        transactionService.update_fine(id,amount);
       return new ResponseEntity("Fine amount updated",HttpStatus.ACCEPTED);
    }
}
