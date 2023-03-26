package ir.bookReserveSystem.service;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.repository.AuthorRepository;
import ir.bookReserveSystem.list.CreatePrintList;
import ir.bookReserveSystem.repository.HikariCpAuthorRepository;


public class AuthorService {
    private final AuthorRepository authorRepository = new AuthorRepository();

    public void register(String name, String family, int age) throws Exception {
        Author author = new Author(name, family, age);
        author.setId(generateAuthorId());
        authorRepository.save(author);
    }

    public long generateAuthorId()throws Exception {
        long generator= authorRepository.loadId()+1;
        if (generator==0)generator=1;
        return generator;
    }
public void sortAuthorFamily() throws Exception{
   CreatePrintList createPrintList=new CreatePrintList();
   createPrintList.sortAuthor(authorRepository.loadAll());

}

    @Override
    public String toString() {
        return "AuthorService{" +
                "authorRepository=" + authorRepository +
                '}';
    }
}