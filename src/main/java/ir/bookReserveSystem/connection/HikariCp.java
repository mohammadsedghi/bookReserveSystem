package ir.bookReserveSystem.connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCp {
    private static HikariDataSource datasource;
    static  {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost/publishers");
        config.setUsername("postgres");
        config.setPassword("12345");
        config.setMaximumPoolSize(10);
        config.setAutoCommit(true);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        datasource = new HikariDataSource(config);
    }
public static Connection getConnection()throws SQLException{
    return  datasource.getConnection();
}

}
