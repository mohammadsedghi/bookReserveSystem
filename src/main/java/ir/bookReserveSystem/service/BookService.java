package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.AuthorRepository;
import ir.bookReserveSystem.repository.BookRepository;

import java.sql.*;

public class BookService {
    public final BookRepository bookRepository = new BookRepository();
    public final AuthorRepository authorRepository = new AuthorRepository();
//addBook method  can added book in database
    public void addBook(String title, int printYear, long authorId) throws Exception {

        Book book = new Book(title, printYear, authorId);
        book.setBookId(bookIdGenerator());
        Author author = authorRepository.load(authorId);
        String str = author.getName().concat(author.getFamily());
        book.setAuthorNameFamily(str);
        bookRepository.save(book);
    }
//generate book id
    public long bookIdGenerator() throws Exception {
        long generator = bookRepository.loadId() + 1;
        return generator;
    }
//load all of book from database
    public Book[] authorBookList(long authorId) throws Exception {
        BookRepository bookRepository = new BookRepository();
        Book[] books = bookRepository.loadAll();
        Book[] authorBooks = new Book[books.length];
        int counter = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthorId() == authorId) {
                authorBooks[counter] = books[i];
                counter++;

        }
    }
        return authorBooks;
}
public void deleteBook(long bookId )throws Exception{
        Book book=new Book();
        book.setBookId(bookId);
        bookRepository.delete(book);
}


}
