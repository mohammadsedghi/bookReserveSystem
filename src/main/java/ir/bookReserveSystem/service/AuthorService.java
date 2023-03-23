package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.AuthorRepository;
import ir.bookReserveSystem.repository.BookRepository;

public class AuthorService {
    private final AuthorRepository authorRepository = new AuthorRepository();

    public void register(String name, String family, int age) throws Exception {
        Author author = new Author(name, family, age);
        author.setId(10l);
        authorRepository.save(author);
    }

    public long generateAuthorId() {
        return 0;
    }


    @Override
    public String toString() {
        return "AuthorService{" +
                "authorRepository=" + authorRepository +
                '}';
    }
}