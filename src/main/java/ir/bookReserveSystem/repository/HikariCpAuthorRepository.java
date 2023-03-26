package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.HikariCp;
import ir.bookReserveSystem.connection.JdbcConnection;
import ir.bookReserveSystem.entity.Author;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HikariCpAuthorRepository {
    public static Author[] loadAll() throws SQLException {
        DataSource dataSource= HikariCp.getDataSource();
        Connection connection = dataSource.getConnection();
        final String QUERY1 = "select * from author ";

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
