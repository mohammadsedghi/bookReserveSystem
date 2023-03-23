package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.BookRepository;

public class BookService {
    public final BookRepository bookRepository=new BookRepository();
    public void addBook(String title,int printYear,int authorId) throws Exception{
        Book book=new Book(title,printYear,authorId);
        bookRepository.save(book);
    }

}
