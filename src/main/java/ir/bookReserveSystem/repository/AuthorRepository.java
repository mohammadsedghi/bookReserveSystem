package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) throws SQLException {
        final String QUERY1 = "insert into author(id, name, family,age) VALUES (?,?,?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1,author.getId());
        statement.setString(2, author.getName());
        statement.setString(3, author.getFamily());
        statement.setInt(4, author.getAge());
        statement.execute();
        System.out.println("save in the database");
    }

    public Author load(int authorId) throws Exception {
        Author author = new Author();
        final String QUERY1 = "select * from author where id=?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, authorId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        author.setId(resultSet.getLong("id"));
        author.setName(resultSet.getString("name"));
        author.setFamily(resultSet.getString("family"));
        author.setAge(resultSet.getInt("age"));
        return author;
    }
}
