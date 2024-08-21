package com.example.DigitalLibrary.service.serviceImpl;

import com.example.DigitalLibrary.dtos.SearchBookRequest;
import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.entites.Student;
import com.example.DigitalLibrary.entites.Transaction;
import com.example.DigitalLibrary.repository.TransactionRepository;
import com.example.DigitalLibrary.service.BookService;
import com.example.DigitalLibrary.service.StudentService;
import com.example.DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.example.DigitalLibrary.entites.enums.TransactionStatus.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionRepository transactionRepo;

    @Value(" ${student.issue.max}")
    Integer maxBooksForIssuance;
    @Override
    public String issueBook(String book_name, long student_Id) throws Exception{
        //find if book is available
        //check if booklimit for student is exceeded
        //create transaction object
        //assign book to student
        //set transaction
        //save transaction
        List<Book> booksInLibrary=new ArrayList<>();
        try {
            SearchBookRequest bookToSearch = SearchBookRequest.builder()
                    .searchKey("name")
                    .searchValue(book_name)
                    .operator("=")
                    .build();


             booksInLibrary = bookService.searchBook(bookToSearch);
        }catch(Exception E){
            throw new Exception("Book not found");

        }
        if(booksInLibrary.isEmpty()) {
            throw new Exception("Book not available or not found");
        }

        //get books currently with student
        //so get student obj
        Student s=studentService.getStudentDetails(student_Id);

        if(s.getBookList() != null  && s.getBookList().size()> maxBooksForIssuance){
            throw new Exception ("Book Limit Reached");
        }

        Book book= s.getBookList().get(0);

        //create Transaction Object
        Transaction trans=Transaction.builder()
                .externalTxnId(String.valueOf(UUID.randomUUID()))
                .book(book)
                .student(s)
                .transactionStatus(PENDING)
                .build();
        //assign book to student
        try {
            //since this is bidirectional relationship associate objects
            //and cascade given so if book is saved student is also saved
            //also if book saved transaction is also saved
            book.setStudent(s);
            book.addTransaction(trans);
            bookService.assignBookToStudent(book);
            trans.setTransactionStatus(SUCCESS);
            return trans.getExternalTxnId();

        }catch(Exception e){
            trans.setTransactionStatus(FAILED);

        }finally{
            return transactionRepo.save(trans).getExternalTxnId();

        }
    }
}
