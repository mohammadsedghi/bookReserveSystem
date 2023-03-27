package ir.bookReserveSystem.repository;

import ir.bookReserveSystem.connection.HikariCp;
import ir.bookReserveSystem.entity.Author;
import ir.bookReserveSystem.entity.Book;

import javax.sql.DataSource;
import java.sql.*;

public class AuthorRepository {
    //save author in database
    public void save(Author author) throws SQLException {
        final String QUERY1 = "insert into author(id, name, family,age) VALUES (?,?,?,?)";
       Connection connection=HikariCp.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1, author.getId());
        statement.setString(2, author.getName());
        statement.setString(3, author.getFamily());
        statement.setInt(4, author.getAge());
        statement.execute();
        System.out.println("save author"+author.getFamily()+" in the database");
        statement.close();
        connection.close();
    }

    public int save1(Author author ) throws SQLException {
        final String QUERY1 = "insert into author(id, name, family,age) VALUES (?,?,?,?)";
       Connection connection=HikariCp.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1, Statement.RETURN_GENERATED_KEYS);
       statement.setLong(1,author.getId());
        statement.setString(2, author.getName());
        statement.setString(3, author.getFamily());
        statement.setInt(4,author.getAge());
        statement.execute();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt("id");
        System.out.println("commit in the database");
        statement.close();
        connection.close();
        return id;
    }
    //load author from database
    public Author load(long authorId) throws Exception {
        Author author = new Author();
        final String QUERY1 = "select * from author where id=?";
       Connection connection=HikariCp.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1, authorId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) return null;
        author.setId(resultSet.getLong("id"));
        author.setName(resultSet.getString("name"));
        author.setFamily(resultSet.getString("family"));
        author.setAge(resultSet.getInt("age"));
        statement.close();
        connection.close();
        return author;
    }
    //load id of author from database
    public long loadId() throws SQLException {
        long id = 0;
        final String QUERY1 = "select * from author ";
       Connection connection=HikariCp.getConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getLong("id");
        }
        statement.close();
        connection.close();
        return id;
    }
    //load all of author from database
    public Author[] loadAll() throws SQLException {
        final String QUERY1 = "select * from author ";
       Connection connection=HikariCp.getConnection();
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
            Author author = new Author();
            author.setId(resultSet.getLong("id"));
            author.setName(resultSet.getString("name"));
            author.setFamily(resultSet.getString("family"));
            author.setAge(resultSet.getInt("age"));
            authors[i++] = author;
        }
        statement.close();
        connection.close();
        return authors;
    }
    public void delete(Author author) throws SQLException {
        Connection connection=HikariCp.getConnection();
        final String QUERY1 = "delete from author where id = ?";
        PreparedStatement statement = connection.prepareStatement(QUERY1);
        statement.setLong(1, author.getId());
        statement.execute();
        System.out.println("the author with id "+author.getId()+" deleted");
        statement.close();
        connection.close();

    }

}
