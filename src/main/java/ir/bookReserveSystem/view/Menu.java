package ir.bookReserveSystem.view;

import ir.bookReserveSystem.list.CreateListAuthorBook;
import ir.bookReserveSystem.service.AuthorService;
import ir.bookReserveSystem.service.BookService;

import java.util.Scanner;

public class Menu {
    //composition
   private CreateListAuthorBook createListAuthorBook = new CreateListAuthorBook();
   private AuthorService authorService = new AuthorService();
   private BookService bookService = new BookService();

//this method run  program and call other classes and print menu for end user
    public void runPublishers() throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("#############################################################");
            System.out.println("menu: 1-create author from list");
            System.out.println("menu: 2-create one author");
            System.out.println("menu: 3-create book from list");
            System.out.println("menu: 4-sort author family");
            System.out.println("menu: 5-create print book of author with id ");
            System.out.println("menu: 6-print all of book from all author and their info ");
            System.out.println("menu: 7-delete author");
            System.out.println("menu: 8-delete book");
            System.out.println("menu: 9-EXIT");
            System.out.println("#############################################################");
            System.out.println("inter your menu number:");
            switch (scanner.nextInt()) {
                case 1:
                    createListAuthorBook.createAuthorFromList();
                    break;
                case 2:authorService.createOneAuthor();
                break;
                case 3:
                    createListAuthorBook.createBook();
                    break;

                case 4:
                    authorService.sortAuthorFamily();
                    break;

                case 5:
                    System.out.println("inter your favorite author id  ");
                    createListAuthorBook.printAuthorBook(scanner.nextInt());
                    break;

                case 6:
                    authorService.printAuthorInfo();
                    break;
                case 7:
                    System.out.println("inter your authorId  that you want delete  ");
                    authorService.deleteAuthor(scanner.nextInt());
                    break;
                case 8:
                    System.out.println("inter your bookId  that you want delete  ");
                    bookService.deleteBook(scanner.nextInt());
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }
}