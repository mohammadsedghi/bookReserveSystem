package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) throws SQLException {
        final String QUERY1 = "insert into author( name, family,age) VALUES (?,?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setString(1, author.getName());
        statement.setString(2, author.getFamily());
        statement.setInt(3, author.getAge());
        statement.execute();
        System.out.println("save in the database");
    }

    public Author load(int personId) throws Exception {
        Author author = new Author();
        final String QUERY1 = "select * from person where id=?";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setInt(1, personId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        author.setId(resultSet.getLong("id"));
        author.setName(resultSet.getString("name"));
        author.setFamily(resultSet.getString("family"));
        author.setAge(resultSet.getInt("age"));
        return author;
    }
}
