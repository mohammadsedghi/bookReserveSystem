package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.BookRepository;

public class BookService {
    public final BookRepository bookRepository=new BookRepository();
    public void addBook(String title,int printYear,long authorId) throws Exception{
        Book book=new Book(title,printYear,authorId);
        book.setBookId(bookIdGenerator(authorId));
        book.setAuthorNameFamily("alisedghi");
        bookRepository.save(book);
    }
    public long  bookIdGenerator(long authorId){
        authorId+=1;
       long generator=authorId;
       return generator;
    }
    public Book[] authorBookList(long authorId) throws Exception {
        BookRepository bookRepository = new BookRepository();
        Book[] books = bookRepository.loadAll();
        Book[] authorBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthorId() == authorId) {
                for (int j = 0; j < authorBooks.length; j++) {
                    authorBooks[j] = books[i];

                }
            }
        }
        return authorBooks;
    }

    @Override
    public String toString() {
        return "BookRepository{}";
    }
}
