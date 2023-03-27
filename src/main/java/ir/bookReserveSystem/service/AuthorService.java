package ir.bookReserveSystem.service;

import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.repository.AuthorRepository;
import ir.bookReserveSystem.list.CreateListAuthorBook;

import java.util.Scanner;
import java.util.regex.Pattern;


public class AuthorService {
    public static long specialId = 0;
    boolean flag = false;
    private final AuthorRepository authorRepository = new AuthorRepository();
    private BookService bookService = new BookService();

    //before register author check name that lowercase or no then call save method to register it
    public void register(String name, String family, int age) throws Exception {
        if (Pattern.matches("[a-z]*", name)) {
            Author author = new Author(name, family, age);
            author.setId(generateAuthorId());
            // authorRepository.save(author);
            System.out.println(authorRepository.save1(author));
        } else {
            System.out.println("your name must be written lowercase , please Run program again");
            System.exit(0);
        }
    }

    public void createOneAuthor() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inter name:");
        String name = scanner.next();
        System.out.println("inter family");
        String family = scanner.next();
        System.out.println("inter age");
        int age = scanner.nextInt();
        register(name, family, age);
    }

    //generate id for author
    public long generateAuthorId() throws Exception {
        long generator = authorRepository.loadId() + 1;
        if (generator == 0) generator = 1;
        return generator;
    }

    //after load author from database sort family of them
    public void sortAuthorFamily() throws Exception {
        CreateListAuthorBook createListAuthorBook = new CreateListAuthorBook();
        createListAuthorBook.sortAuthor(authorRepository.loadAll());

    }

    //print all of information of author with list of book
    public void printAuthorInfo() throws Exception {
        Author[] authors = authorRepository.loadAll();

        for (int i = 0; i < authorRepository.loadAll().length; i++) {
                authors[i].setBooks(bookService.authorBookList(i+1));
        }
        for (Author a : authors
        ) {
            System.out.println(a);
        }
    }

    //delete author with id that user inter it
    public void deleteAuthor(long authorId) throws Exception {
        specialId = authorId;
        flag = true;
        Author author = new Author();
        author.setId(authorId);
        authorRepository.delete(author);
        //bookService.deleteBookAuthorId(authorId);
    }

    @Override
    public String toString() {
        return "AuthorService{" +
                "authorRepository=" + authorRepository +
                '}';
    }
}