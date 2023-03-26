package ir.bookReserveSystem.list;
import ir.bookReserveSystem.service.AuthorService;

public class Main {
    public static void main(String[] args) throws Exception{
CreatePrintList createPrintList=new CreatePrintList();
        AuthorService authorService=new AuthorService();
//createPrintList.createAuthor();
//createPrintList.createBook();
//createPrintList.printAuthorBook();
//authorService.sortAuthorFamily();
        authorService.printAuthorInfo();
    }
}