package com.example.DigitalLibrary.service.serviceImpl;

import com.example.DigitalLibrary.dtos.CreateBookRequest;
import com.example.DigitalLibrary.dtos.SearchBookRequest;
import com.example.DigitalLibrary.entites.Author;
import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.entites.enums.Genre;
import com.example.DigitalLibrary.repository.BookRepository;
import com.example.DigitalLibrary.service.AuthorService;
import com.example.DigitalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorService authorService;
    @Override
    public Book createBook(CreateBookRequest book) {
        //without saving author do not create book else you end up creating new authors
        // 1.author has to be assigned to book
        //if author also new craete new author or else get new author
        //then create book
        Book bookinRepo= book.to();
        Author author=authorService.createOrGet(bookinRepo.getAuthor());
        bookinRepo.setAuthor(author);
        return bookRepo.save(bookinRepo);

    }

    @Override
    public List<Book> searchBook(SearchBookRequest bookToSearch) throws Exception{
        String searchKey= bookToSearch.getSearchKey();
        switch(searchKey) {
            case "name":
                return bookRepo.findByName(bookToSearch.getSearchValue());
            case "genre":
                return bookRepo.findByGenre(Genre.valueOf(bookToSearch.getSearchValue()));
            case "id":
                Book book = bookRepo.findById(Integer.parseInt(bookToSearch.getSearchValue()))
                        .orElse(null);
                return Arrays.asList(book);
            default:
                throw new Exception();
        }

    }

    @Override
    public Boolean isValidBookSearch(SearchBookRequest bookToSearch) {
        Map<String,List<String>> keyOperatorMap=SearchBookRequest.getAllowedKeyOperatorMap();
        String givenKey= bookToSearch.getSearchKey();

        if(keyOperatorMap.containsKey(givenKey)){
            return false;
        }

        return true;
    }

    public Book assignBookToStudent(Book book){
        return bookRepo.save(book);
    }

   /* @Override
    public GetBookResponse getBookDetails(int bookId) {
        return null;
    }

    @Override
    public String updateBookDetails(int bookId, createBookRequest book) {
        return null;
    }

    @Override
    public String deleteBook(int bookId) {
        return null;
    }*/
}
