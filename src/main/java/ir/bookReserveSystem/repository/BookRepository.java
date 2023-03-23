package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {
    public void save(Book book) throws SQLException {
        final String QUERY1 = "insert into book( id, title,authorNameFamily,printYear) VALUES (?,?,?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1,book.getBookId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthorNameFamily());
        statement.setInt(4, book.getPrintYear());
        statement.execute();
        System.out.println("save book in the database");
    }

    public Book load(int bookId) throws Exception {
        Book book = new Book();
        final String QUERY1 = "select * from book where id=?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, bookId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        book.setBookId(resultSet.getLong("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthorNameFamily(resultSet.getString("authorNameFamily"));
        book.setPrintYear(resultSet.getInt("printYear"));
        return book;
    }
 public void delete(Book book) throws SQLException {
    final String QUERY1 = "delete from book where id = ?";
    Connection connection = JdbcConnection.getConnection();
    PreparedStatement statement = connection.prepareStatement(QUERY1);
    statement.setLong(1, book.getBookId());
    statement.execute();
    System.out.println("delete");
}
}

