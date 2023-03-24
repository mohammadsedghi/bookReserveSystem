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
     //  authorService.register("reza","rezaee",30);
       String[] title={"culture","economy","social","math","history"};
        for (int j = 0; j < 5; j++) {
            int i=2016;
            bookService.addBook(title[j], i+j, 2);

          }
        for (Book b:bookService.authorBookList(2)
             ) {
            if (b!=null) System.out.println(b);

        }

    }
}