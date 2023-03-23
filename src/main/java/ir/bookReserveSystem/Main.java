package ir.bookReserveSystem;

import ir.bookReserveSystem.service.AuthorService;
import ir.bookReserveSystem.service.BookService;

public class Main {
    public static void main(String[] args) throws Exception{

        AuthorService authorService=new AuthorService();
        BookService bookService=new BookService();
       // authorService.register("ali","sedghi",20);
       // bookService.addBook("culture",2023,10);
        bookService.authorBookList(10);
    }
}