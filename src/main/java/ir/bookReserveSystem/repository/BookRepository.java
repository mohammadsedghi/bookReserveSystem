package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.HikariCp;
import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;

import javax.sql.DataSource;
import java.sql.*;

public class BookRepository {
    public void save(Book book) throws SQLException {
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        final String QUERY1 = "insert into book( id, title,authorNameFamily,printYear,authorid) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1,book.getBookId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthorNameFamily());
        statement.setInt(4, book.getPrintYear());
        statement.setLong(5,book.getAuthorId());
        statement.execute();
        System.out.println("save book in the database");
        connection.close();
    }

    public Book load(int bookId) throws Exception {
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        Book book = new Book();
        final String QUERY1 = "select * from book where id=?";
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, bookId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        book.setBookId(resultSet.getLong("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthorNameFamily(resultSet.getString("authorNameFamily"));
        book.setPrintYear(resultSet.getInt("printYear"));
        book.setAuthorId(resultSet.getLong("authorid"));
        return book;
    }
 public void delete(Book book) throws SQLException {
     DataSource dataSource= HikariCp.getDataSource();
     Connection connection = dataSource.getConnection();
    final String QUERY1 = "delete from book where id = ?";
    PreparedStatement statement = connection.prepareStatement(QUERY1);
    statement.setLong(1, book.getBookId());
    statement.execute();
    System.out.println("delete");
}
    public Book[] loadAll() throws Exception {
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        final String QUERY1 = "select * from book ";
        PreparedStatement statement = connection.prepareStatement(QUERY1,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery();
        int size = 0;
        resultSet.last();
        size = resultSet.getRow();
        resultSet.beforeFirst();
        Author author=new Author();
        Book[] books = new Book[size];
        int i = 0;
        while (resultSet.next()) {
            Book book = new Book();
            book.setBookId(resultSet.getLong("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthorNameFamily(resultSet.getString("authornamefamily"));
            book.setPrintYear(resultSet.getInt("printyear"));
            book.setAuthorId(resultSet.getLong("authorid"));
            books[i++] = book;
        }
        connection.close();
        return books;
    }
    public long loadId() throws SQLException {
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        long id=0;
        final String QUERY1 = "select * from book ";
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        ResultSet resultSet = statement.executeQuery();
       while (resultSet.next()){
         id = resultSet.getLong("id");
       }
        return id;
    }
}





