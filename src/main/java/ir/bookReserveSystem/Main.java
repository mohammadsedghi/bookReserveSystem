package ir.bookReserveSystem;

import ir.bookReserveSystem.service.AuthorService;
import ir.bookReserveSystem.service.BookService;
import ir.bookReserveSystem.entity.Book;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

        AuthorService authorService=new AuthorService();
        BookService bookService=new BookService();
       authorService.register("ali","sedghi",20);
       bookService.addBook("economy",2023,1);
        for (Book b:bookService.authorBookList(1)
             ) {
            if (b!=null) System.out.println(b);
        }

    }
}