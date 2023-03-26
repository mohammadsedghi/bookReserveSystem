package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.HikariCp;
import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) throws SQLException {
        final String QUERY1 = "insert into author(id, name, family,age) VALUES (?,?,?,?)";
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1,author.getId());
        statement.setString(2, author.getName());
        statement.setString(3, author.getFamily());
        statement.setInt(4, author.getAge());
        statement.execute();
        System.out.println("save in the database");
    }

    public Author load(long authorId) throws Exception {
        Author author = new Author();
        final String QUERY1 = "select * from author where id=?";
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1, authorId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        author.setId(resultSet.getLong("id"));
        author.setName(resultSet.getString("name"));
        author.setFamily(resultSet.getString("family"));
        author.setAge(resultSet.getInt("age"));
        return author;
    }
    public long loadId() throws SQLException {
        long id=0;
        final String QUERY1 = "select * from author ";
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            id = resultSet.getLong("id");
        }
        return id;
    }
    public Author[] loadAll() throws SQLException {
        final String QUERY1 = "select * from author ";
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery();
        int size = 0;
        resultSet.last();
        size = resultSet.getRow();
        resultSet.beforeFirst();
        Author[] authors = new Author[size];
        int i = 0;
        while (resultSet.next()) {
            Author author=new Author();
            author.setId(resultSet.getLong("id"));
            author.setName(resultSet.getString("name"));
            author.setFamily(resultSet.getString("family"));
            author.setAge(resultSet.getInt("age"));
            authors[i++] = author;
        }
        return authors;
    }
}
