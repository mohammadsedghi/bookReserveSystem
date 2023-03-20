package ir.bookReserveSystem.entity;

public class Book {
   private String title;
   private int printYear;
    private String AuthorNameFamily;
    private long authorId;
private Long BookId;

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrintYear() {
        return printYear;
    }

    public void setPrintYear(int printYear) {
        this.printYear = printYear;
    }

    public String getAuthorNameFamily() {
        return AuthorNameFamily;
    }

    public void setAuthorNameFamily(String authorNameFamily) {
        AuthorNameFamily = authorNameFamily;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }



    public Book(String title, int printYear, String authorNameFamily, int authorId) {
        this.title = title;
        this.printYear = printYear;
        AuthorNameFamily = authorNameFamily;
        this.authorId = authorId;
    }
}
