package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.repository.AuthorRepository;

public class AuthorService {
    private final AuthorRepository authorRepository=new AuthorRepository();
    public void save(String name,String family,int age)throws Exception{
        Author author=new Author(name,family,age);
        authorRepository.save(author);
    }

}
