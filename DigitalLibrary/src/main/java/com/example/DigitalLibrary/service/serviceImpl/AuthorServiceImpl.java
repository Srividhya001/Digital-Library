package com.example.DigitalLibrary.service.serviceImpl;

import com.example.DigitalLibrary.entites.Author;
import com.example.DigitalLibrary.repository.AuthorRepository;
import com.example.DigitalLibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Author createOrGet(Author author) {

       Author authorFromRepo= authorRepository.findByEmail(author.getEmail());
      if(authorFromRepo== null){
          //author not present
          return authorRepository.save(authorFromRepo);
      }

        return authorFromRepo;
    }
}
