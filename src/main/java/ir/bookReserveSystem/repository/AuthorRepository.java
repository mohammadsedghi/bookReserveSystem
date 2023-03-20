package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) throws SQLException {
        final String QUERY1 = "insert into author( name, family,age) VALUES (?,?,?)";
        Connection connection = JdbcConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setString(1, author.getName());
        statement.setString(2, author.getFamily());
        statement.setInt(3,author.getAge());
        statement.execute();
        System.out.println("save in the database");
    }
}
