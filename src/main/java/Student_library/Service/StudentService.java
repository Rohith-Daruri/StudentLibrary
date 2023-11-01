package Student_library.Service;

import Student_library.DTO.RequestDTO.StudentRequest;
import Student_library.DTO.ResponseDTO.CardResponse;
import Student_library.DTO.ResponseDTO.StudentResponse;
import Student_library.Enum.CardStatus;
import Student_library.Model.Library_card;
import Student_library.Model.Student;
import Student_library.Repository.StudentRepository;
import Student_library.Transformer.StudentTransformer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public StudentResponse addStudent(StudentRequest studentRequest) throws MessagingException {
        Student student = StudentTransformer.RequestToModel(studentRequest);
        Library_card libraryCard = new Library_card();
        libraryCard.setCard_no(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setBooks_Taken(0);
        libraryCard.setBooks_withheld(0);
        libraryCard.setBooks_Returned(0);
        libraryCard.setStudent(student);
        student.setLibraryCard(libraryCard);
        Student saved_student = studentRepository.save(student);
        String text = "Congratulations!!!\n" + "\n" + "Hi " + saved_student.getName() + "\n"+"\n" + "Your Registration is successful.\n" + "\n" + "Please find the Registration details below.\n" + "\n" + "Card No:- " + saved_student.getLibraryCard().getCard_no() + "\n" + "Card status:- " + student.getLibraryCard().getCardStatus() + "\n" + "\n" + "\n" + "Regards,\n" + "\n" + "RD INSTITUTIONS,\n" + "Tirupati, Andhra Pradesh.\n" + "Phone:- 8296431478.\n" + "\n" + "www.rdinstitutions.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("acciospringtest@gmail.com");
        mimeMessageHelper.setTo(saved_student.getEmail());
        mimeMessageHelper.setSubject("Congratulations!!!! Registration Done");
        mimeMessageHelper.setText(text);
        StudentResponse studentResponse = new StudentResponse();
        String attachment = "C:\\Users\\RD\\Desktop\\RD-Aster.pdf";
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("acciospringtest@gmail.com");
        simpleMailMessage.setTo(saved_student.getEmail());
        simpleMailMessage.setSubject("Account Created!!!");
        simpleMailMessage.setText(text);
        CardResponse cardResponse = new CardResponse();
        cardResponse.setCardStatus(saved_student.getLibraryCard().getCardStatus());
        cardResponse.setCard_No(saved_student.getLibraryCard().getCard_no());
        studentResponse.setCardResponse(cardResponse);
        studentResponse.setName(saved_student.getName());
        return studentResponse;
    }
}
