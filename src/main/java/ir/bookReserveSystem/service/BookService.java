package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.BookRepository;

public class BookService {
    public final BookRepository bookRepository=new BookRepository();
    public void addBook(String title,int printYear,int authorId) throws Exception{
        Book book=new Book(title,printYear,authorId);
        book.setBookId(bookIdGenerator(authorId));
        book.setAuthorNameFamily("alisedghi");
        bookRepository.save(book);
    }
    public long  bookIdGenerator(int authorId){
        authorId+=1;
       long generator=authorId;
       return generator;
    }

}
