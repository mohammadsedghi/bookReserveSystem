package ir.bookReserveSystem.entity;

public class Author {
    //variable
   private String name,family;
    private int age;
    private Book[] books=new Book[100];
    private long id;
    public Book[] getBooks() {
        return books;
    }
    //constructor with initialize variable
    public Author(String name, String family, int age) {
        this.name = name;
        this.family = family;
        this.age = age;
    }
    //constructor with none entrance
    public Author() {
    }
//getter and setter
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public void setBooks(Book[] books) {
        this.books = books;
    }
}
