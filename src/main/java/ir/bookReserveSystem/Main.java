package ir.bookReserveSystem;

import ir.bookReserveSystem.service.AuthorService;
import ir.bookReserveSystem.service.BookService;
import ir.bookReserveSystem.entity.Book;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

        AuthorService authorService=new AuthorService();
        BookService bookService=new BookService();
       // authorService.register("ali","sedghi",20);
       // bookService.addBook("culture",2023,10);
        for (Book b:bookService.authorBookList(10)
             ) {
            if (b!=null) System.out.println(b);
        }

    }
}