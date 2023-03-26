package ir.bookReserveSystem.list;

import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;
import ir.bookReserveSystem.service.AuthorService;
import ir.bookReserveSystem.service.BookService;

public class CreatePrintList {
    //composition
    AuthorService authorService=new AuthorService();
    BookService bookService=new BookService();

//create author method
   public void createAuthor()throws Exception{
       String[] authorName={"ali","reza","nima","mahan"};
       String[] authorFamily={"sedghi","arghan","rostami","tehrani"};
       for (int i = 0; i <authorName.length ; i++) {
           authorService.register(authorName[i],authorFamily[i],i+20);
       }
       System.out.println("list of author created");
   }

//create book method

    public void createBook()throws Exception{
        String[] title={"culture","economy","social","math","history"};
        for (int i = 1; i <5 ; i++) {
        for (int j = 0; j < 5; j++) {
            int k=2016;
            bookService.addBook(title[j], k+j, i);

        }}
        System.out.println("list of book created");
    }
    //print book of author
   public void printAuthorBook()throws Exception {
       for (Book b : bookService.authorBookList(2)
       ) {
           if (b != null) System.out.println(b);

       }
   }
   //sort of family author
   public void sortAuthor(Author[] authors){
       int n = 4;
       String [] family=new String[authors.length];
       // create string array called names
       for (int i = 0; i <authors.length ; i++) {
        family[i]=authors[i].getFamily();
       }
       String temp;
       for (int i = 0; i < n; i++) {
           for (int j = i + 1; j < n; j++) {

               // to compare one string with other strings
               if (family[i].compareTo(family[j]) > 0) {
                   // swapping
                   temp = family[i];
                   family[i] = family[j];
                   family[j] = temp;
               }
           }
       }

       // print output array
       System.out.println(
               "The author family in alphabetical order are: ");
       for (int i = 0; i < n; i++) {
           System.out.println(family[i]);
       }
   }



}
