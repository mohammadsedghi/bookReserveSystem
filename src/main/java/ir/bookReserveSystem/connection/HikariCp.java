package ir.bookReserveSystem.connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class HikariCp {
    private static DataSource datasource;

    public static DataSource getDataSource()
    {
        if(datasource == null)
        {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost/publishers");
            config.setUsername("postgres");
            config.setPassword("12345");

            config.setMaximumPoolSize(10);
            config.setAutoCommit(false);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            datasource = new HikariDataSource(config);
        }
        return datasource;
    }
}
