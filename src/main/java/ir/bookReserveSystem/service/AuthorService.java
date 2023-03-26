package ir.bookReserveSystem.service;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.repository.AuthorRepository;
import ir.bookReserveSystem.list.CreatePrintList;
import ir.bookReserveSystem.service.BookService;

import java.util.regex.Pattern;


public class AuthorService {
    private final AuthorRepository authorRepository = new AuthorRepository();
    private BookService bookService=new BookService();
//before register author check name that lowercase or no then call save method to register it
    public void register(String name, String family, int age) throws Exception {
        if (Pattern.matches("[a-z]*",name)){
        Author author = new Author(name, family, age);
        author.setId(generateAuthorId());
        authorRepository.save(author);
    }else{
            System.out.println("your name must be written lowercase , please Run program again");
            System.exit(0);}
    }
//generate id for author
    public long generateAuthorId()throws Exception {
        long generator= authorRepository.loadId()+1;
        if (generator==0)generator=1;
        return generator;
    }
    //after load author from database sort family of them
public void sortAuthorFamily() throws Exception{
   CreatePrintList createPrintList=new CreatePrintList();
   createPrintList.sortAuthor(authorRepository.loadAll());

}
public void printAuthorInfo()throws Exception{
    Author[] authors=authorRepository.loadAll();

    for (int i = 0; i < authorRepository.loadAll().length; i++) {
     authors[i] .setBooks(bookService.authorBookList(i+1));

    }
    for (Author a:authors
         ) {
        System.out.println(a);
    }
}

    @Override
    public String toString() {
        return "AuthorService{" +
                "authorRepository=" + authorRepository +
                '}';
    }
}